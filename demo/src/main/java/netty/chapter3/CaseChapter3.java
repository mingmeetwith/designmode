package netty.chapter3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaseChapter3 {

}

class RouterServerHandler extends ChannelInboundHandlerAdapter{
    static ExecutorService executorService= Executors.newSingleThreadExecutor();
    PooledByteBufAllocator allocator = new PooledByteBufAllocator(false);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // super.channelRead(ctx, msg);
        ByteBuf reqMsg = (ByteBuf)msg;
        byte[] body = new byte[reqMsg.readableBytes()];
        executorService.execute(()->{
            // 解析请求消息，做路由转发，代码省略
            // 转发成功，返回响应给客户端
            ByteBuf respMsg = allocator.heapBuffer(body.length);
            respMsg.writeBytes(body);
            ctx.writeAndFlush(respMsg);
        });
    }
}
