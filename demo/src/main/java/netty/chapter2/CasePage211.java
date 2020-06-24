package netty.chapter2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;

public class CasePage211 {
    public static void main(String[] argc){
        ClientPool clientPool = new ClientPool();
        try {
//            clientPool.initClientPool(10);
            clientPool.initClientPoolRight(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ClientPool{
    // 实际为BIO， 错用NIO编程模式
    public void initClientPool(int poolSize) throws InterruptedException {
        for(int i = 0; i<poolSize; i++){
            EventLoopGroup group = new NioEventLoopGroup();
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(new LoggingHandler());
                        }
                    });
            ChannelFuture f = b.connect("127.0.0.1", 18080).sync();
            f.channel().closeFuture().addListener((r)->{
                group.shutdownGracefully();
            });
        }
    }

    public void initClientPoolRight(int poolSize) throws InterruptedException {
            EventLoopGroup group = new NioEventLoopGroup();
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(new LoggingHandler());
                        }
                    });
        for(int i = 0; i<poolSize; i++) {
            b.connect("127.0.0.1", 18080).sync();
        }
//            f.channel().closeFuture().addListener((r)->{
//                group.shutdownGracefully();
//            });
        }
    }