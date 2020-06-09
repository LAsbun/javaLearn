import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.entity.A;
import model.entity.B;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

/**
 * @author: louxiu@wacai.com
 * @create: 20190119 5:05 PM
 */
@SpringBootApplication
@Slf4j
public class Main {

    public static void main(String[] args) {

//        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//            threadPoolExecutor.submit(() -> {
//                try {
//                    System.out.println(
//                            System.currentTimeMillis() + " " + Thread.currentThread().getName() + "start");
//                    Thread.sleep(3000);
//                    System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "end");
//                } catch (InterruptedException e) {
//                    log.info("xxxx");
//                } catch (Exception e) {
//                    log.info("", e);
//                }
//            });
//
//        }
//
////        threadPoolExecutor.submit(new TestInnerCallTask());
//
//
//        threadPoolExecutor.shutdown();

        A a = buildB();
        a.setA(934);

        System.out.println(JSONObject.toJSONString(a));
    }

    public static B buildB(){
        B b = new B();
        b.setB(111);
        return b;
    }


}
