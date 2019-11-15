package javaniopractice;

import java.nio.IntBuffer;

/**
 * @author buffer 实际上需要注意三个内置变量
 *
 * private int position = 0; //当前位置
 *
 * private int limit;  //
 *
 * limit - position 表示此时还可以写入/读取多少单位的数据.
 *
 * 例如在写模式, 如果此时 limit 是10, position 是2, 则表示已经写入了2个单位的数据, 还可以写入
 * 10 - 2 = 8 个单位的数据.
 *
 * private int capacity;  //容量
 */
public class BufferTest {


  public static void main(String[] args) {
    IntBuffer intBuffer = IntBuffer.allocate(5);
    intBuffer.put(12345678);
    intBuffer.put(2);
    intBuffer.put(3);
    System.err.println(intBuffer.mark());

    intBuffer.put(4);

    System.err.println(intBuffer.mark());

    intBuffer.put(5);
    intBuffer.flip();
    System.err.println(intBuffer.get());
    System.err.println(intBuffer.position());
    System.err.println(intBuffer.get());
    System.err.println(intBuffer.mark());

    System.err.println("-----------");

    testLimitPosition();


  }

  public static void testLimitPosition(){

    IntBuffer intBuffer = IntBuffer.allocate(10);
    intBuffer.put(10);
    intBuffer.put(101);
    System.err.println("Write mode: ");
    System.err.println("\tCapacity: " + intBuffer.capacity());
    System.err.println("\tPosition: " + intBuffer.position());
    System.err.println("\tLimit: " + intBuffer.limit());

    intBuffer.flip();
    System.err.println("Read mode: ");
    System.err.println("\tCapacity: " + intBuffer.capacity());
    System.err.println("\tPosition: " + intBuffer.position());
    System.err.println("\tLimit: " + intBuffer.limit());

    /**
     *
     Write mode:
       Capacity: 10
       Position: 2
       Limit: 10
     flip之后
     Read mode:
       Capacity: 10
       Position: 0
       Limit: 2
     */


  }

}
