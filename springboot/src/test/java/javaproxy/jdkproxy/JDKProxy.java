package javaproxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDKProxy
 *
 * @author shengweisong
 * @date 2021-09-16 8:35 PM
 **/
@Slf4j
public class JDKProxy implements InvocationHandler {

    private final Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("pre");
        Object invoke = method.invoke(target, args);
        log.info("post");
        return invoke;
    }

    /**
     * 每次都生成一个新的实例
     *
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}