package javaproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 实际实现类
 *
 * @author shengweisong
 * @date 2021-09-16 8:18 PM
 **/
@Slf4j
public class StaticUserDaoImpl implements IUserDao {


    @Override
    public void save() {
        log.info("save");
        new Exception("#").printStackTrace();
    }
}