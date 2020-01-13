package com.jinyue.consumer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

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
