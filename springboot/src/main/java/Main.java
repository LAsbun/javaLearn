import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.entity.A;
import model.entity.B;
import model.entity.Role;
import model.mapper.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;

/**
 * @author: louxiu@wacai.com
 * @create: 20190119 5:05 PM
 */
@SpringBootApplication
@Slf4j
public class Main {

    public static void main(String[] args) {

        testMybatis(args);


//        System.out.println(Runtime.getRuntime().maxMemory() / 1024 /1024);
//
//        String[] bytes = new String[1*1024*1024*1000];
//
//
//        System.out.println("xxx");

//        new Main().testEx();


//        JobInterrupt jobInterrupt = new JobInterrupt();
//        jobInterrupt.start();
//
//        try {
//            Thread.sleep(10000);
//            jobInterrupt.interrupt();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(jobInterrupt.getState());
//
//
//        try {
//            jobInterrupt.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


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

//        A a = buildB();
//        a.setA(934);
//
//        System.out.println(JSONObject.toJSONString(a));
    }

    public static B buildB() {
        B b = new B();
        b.setB(111);
        return b;
    }


    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(4, 50, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3));


    public void testEx() {
        int size = 6;

        for (int i = 0; i < size; i++) {
            executorService.submit(new Job());
        }
        executorService.submit(new JobInterrupt());

        for (int i = 0; i < size; i++) {
            executorService.submit(new Job());
        }

//        try {
//            executorService.awaitTermination(30, TimeUnit.HOURS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int index = 0;
//
//        retr:
//
//        for (; ; ) {
//
//            for (; ; ) {
//                if (++index != 100) {
//                    System.out.println(index);
//
//                    continue retr;
//                } else {
//                    System.out.println("break");
//                    break retr;
//                }
//            }
//        }
//
//        System.out.println("end");


    }


    static class JobInterrupt extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "inte" + "cur: ");
            while (true) {
                try {
                    Thread.sleep(11111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    class Job implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start" + " cur: " + executorService.getPoolSize());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end" + " cur: " + executorService.getPoolSize());
        }

    }


    public static void testMybatis(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = null;
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(5L);
            System.out.println(role.getId() + ":" + role.getRoleName() + ":" + role.getNote());
            sqlSession.commit();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


}
