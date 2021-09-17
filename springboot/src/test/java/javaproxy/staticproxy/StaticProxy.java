package javaproxy.staticproxy;

import javaproxy.IUserDao;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理类
 *
 * @author shengweisong
 * @date 2021-09-16 8:19 PM
 **/
@Slf4j
public class StaticProxy implements IUserDao {


    private final IUserDao target;

    public StaticProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        log.info("pre");
        this.target.save();
        log.info("post");
    }
}