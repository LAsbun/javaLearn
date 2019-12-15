package nettypractice.embeded;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @author
 */
public class FixLengthFrameDecoder extends ByteToMessageDecoder {

  /**
   * 指定帧的长度
   */
  private final int length;

  public FixLengthFrameDecoder(int length) {
    this.length = length;
  }

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    while (in.readableBytes() >= this.length) {
      ByteBuf byteBuf = in.readBytes(this.length);
      out.add(byteBuf);
    }

  }
}
