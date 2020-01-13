package com.jinyue.consumer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 该类主要是客户端请求netty服务端后且当返回结果时，会回调channelRead方法接收rpc调用返回结果
 */
public class ConsumerNettyHandler extends ChannelInboundHandlerAdapter {

    private Object res;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.res = msg;
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    public Object getRes() {
        return res;
    }
}
