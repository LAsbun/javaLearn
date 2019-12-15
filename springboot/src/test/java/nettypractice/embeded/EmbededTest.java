package nettypractice.embeded;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

/**
 * @author
 */
public class EmbededTest {


  @Test
  public void testInReadBound(){
    ByteBuf buffer = Unpooled.buffer(9);

    for (int i = 0; i < 9; i++) {
      buffer.writeByte(i);
    }

    EmbeddedChannel embeddedChannel = new EmbeddedChannel();
    embeddedChannel.pipeline().addLast(new FixLengthFrameDecoder(3));

    embeddedChannel.writeInbound(buffer);
//    buffer.retain()

    ByteBuf o = embeddedChannel.readInbound();
    System.out.println(o.capacity());

     o = embeddedChannel.readInbound();
    System.out.println(o.capacity());

    o = embeddedChannel.readInbound();
    System.out.println(o.capacity());

//    o = embeddedChannel.readInbound();
//    System.out.println(o.capacity());

  }

}
