package javaproxy;

import javaproxy.cglibproxy.CglibProxy;
import javaproxy.cglibproxy.CglibUserDao;
import javaproxy.jdkproxy.JDKProxy;
import javaproxy.staticproxy.StaticProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 静态代理
 *
 * @author shengweisong
 * @date 2021-09-16 8:14 PM
 **/
@Slf4j
public class ProxyTest {

    @Test
    public void staticProxyTest() {

        IUserDao userDao = new StaticUserDaoImpl();

        StaticProxy staticProxy = new StaticProxy(userDao);

        staticProxy.save();

    }

    @Test
    public void dynamicProxyTest() {
        IUserDao userDao = new StaticUserDaoImpl();
        log.info("{}", userDao);

        JDKProxy jdkProxy = new JDKProxy(userDao);


        for (int i = 0; i < 3; i++) {
            IUserDao iUserDao = (IUserDao) jdkProxy.getProxy();
            iUserDao.save();
            log.info("{}", iUserDao);
        }
    }

    @Test
    public void cglibProxyTest() {
        CglibUserDao userDao = new CglibUserDao();
        log.info("{}", userDao);

        CglibProxy jdkProxy = new CglibProxy(userDao);


        for (int i = 0; i < 3; i++) {
            CglibUserDao iUserDao = (CglibUserDao) jdkProxy.getProxy();
            iUserDao.save();
            log.info("{}", iUserDao);
        }
    }
}

