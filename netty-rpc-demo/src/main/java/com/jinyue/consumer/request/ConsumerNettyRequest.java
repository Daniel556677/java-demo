package com.jinyue.consumer.request;

import com.jinyue.common.message.RpcMessage;
import com.jinyue.consumer.handler.ConsumerNettyHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;


public class ConsumerNettyRequest {

    public Object sendRequest(String interfaceName, String methodName, Class<?>[] parameterType, Object[] parameterValues) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ConsumerNettyHandler consumerNettyHandler = new ConsumerNettyHandler();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            // 这里添加解码器和编码器，防止拆包和粘包问题
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0,
                                    4, 0, 4));
                            pipeline.addLast(new LengthFieldPrepender(4));

                            // 这里采用jdk的序列化机制
                            pipeline.addLast("jdkencoder", new ObjectEncoder());
                            pipeline.addLast("jdkdecoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            // 添加自己的业务逻辑，将服务注册的handle添加到pipeline
                            pipeline.addLast(consumerNettyHandler);

                        }
                    });

            ChannelFuture future = bootstrap.connect("127.0.0.1", 8888).sync();
            future.channel().writeAndFlush(new RpcMessage(interfaceName, methodName, parameterType, parameterValues)).sync();
            future.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
        return consumerNettyHandler.getRes();
    }
}
