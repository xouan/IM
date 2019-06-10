package com.xouan.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

public class NettyClient {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8888;

    public static void main(String[] args) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {

                    }
                });
        bootstrap.connect(HOST, PORT)
                .addListener(future -> {
                    if (future.isSuccess()) {
                        System.out.println(new Date() + "： 连接成功");
                    } else {
                        System.out.println(new Date() + ": 连接失败");
                    }
                });

    }
}
