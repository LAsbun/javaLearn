package javaproxy.cglibproxy;

import javaproxy.IUserDao;
import lombok.extern.slf4j.Slf4j;

/**
 * 实际实现类
 *
 * @author shengweisong
 * @date 2021-09-16 8:18 PM
 **/
@Slf4j
public class CglibUserDao {


    public void save() {
        log.info("save");
        new Exception("#").printStackTrace();
    }
}