package concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author
 */
@Slf4j
public class ThreadPoolExecutorTest {


  @Test
  public void test() {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5,
        60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),
        (r, executor) -> { //r:请求执行的任务  executor:当前的线程池
          //打印丢失的任务
          log.error("discard:{}", r.toString());
        });

    for (int i = 0; i < 10; i++) {
      System.out.println(i);
      threadPoolExecutor.submit(() -> {
        try {
          System.out.println(
              System.currentTimeMillis() + " " + Thread.currentThread().getName() + "start");
          Thread.sleep(30000);
          System.out.println(System.currentTimeMillis() + " " +  Thread.currentThread().getName() + "end");
        } catch (InterruptedException e) {
          log.info("xxxx");
        }
        catch (Exception e){
          log.info("", e);
        }
      });

    }
  }

}
