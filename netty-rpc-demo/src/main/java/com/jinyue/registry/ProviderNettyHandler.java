package com.jinyue.registry;

import com.jinyue.common.message.RpcMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.lang.reflect.Method;



/**
 * 将provider的服务实现类注册到本地缓存里面，采用ConcurrentHashMap【key为接口名，value为服务实例】
 * 有consumer调用时，此时roviderRegistryHandler再从缓存实例根据传过来的接口名拿到实现类实例，
 * 然后再拿到实现类实例的方法，再对该方法进行反射调用，最后将调用后的结果返回给consumer即可。
 */
public class ProviderNettyHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当netty服务端接收到有consumer的请求时，此时将会进入到这个channelRead方法
     * 此时就可以把consumer调用的参数提取出来，然后再从缓存注册中心instanceCacheMap里
     * 提取出反射实例，然后进行方法调用，再返回结果给consumer即可
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 提取consumer传递过来的参数
        RpcMessage rpcMessage = (RpcMessage) msg;
        String className = rpcMessage.getClassName();
        String methodName = rpcMessage.getMethodName();
        Class<?>[] parameterType = rpcMessage.getParameterType();
        String parameterValue = rpcMessage.getParameterValue();
        // 将注册缓存instanceCacheMap的provider实例提取出来，然后进行反射调用
        Object instance = ProviderRestry.getInstanceCacheMap().get(className);
        Method method = instance.getClass().getMethod(methodName, parameterType);
        Object res = method.invoke(instance, parameterValue);
        // 最后将结果刷到netty的输出流中返回给consumer
        ctx.writeAndFlush(res);
        ctx.close();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}