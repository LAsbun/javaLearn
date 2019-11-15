package javaniopractice;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.junit.Test;

/**
 * @author Java Nio 与传统io区别
 *
 * 1 Java将数据读取到缓冲区，然后程序对缓冲区进行操作. 而传统io是直接将数据读取到程序中
 *
 * 2 Java Nio是异步的，传统io是同步的
 *
 * 3 Java Nio 有select。 传统Io是没有的.
 */
public class ChannelTest {


  @Test
  public void testRead() throws IOException {

    RandomAccessFile aFile = new RandomAccessFile("test", "rw");
    FileChannel inChannel = aFile.getChannel();

    ByteBuffer buf = ByteBuffer.allocate(48);

    int bytesRead = inChannel.read(buf);
    while (bytesRead != -1) {
      buf.flip();

      while (buf.hasRemaining()) {
        System.out.print((char) buf.get());
      }

      buf.clear();
      bytesRead = inChannel.read(buf);
    }
    aFile.close();

  }

  @Test
  public void write() throws IOException {
    RandomAccessFile aFile = new RandomAccessFile("test", "rw");
    FileChannel channel = aFile.getChannel();

    String newData = "New String to write to file..." + System.currentTimeMillis();

    ByteBuffer buf = ByteBuffer.allocate(48);
    buf.clear();
    buf.put(newData.getBytes());

    buf.flip();

    while (buf.hasRemaining()) {
      channel.write(buf);
    }


  }
}
