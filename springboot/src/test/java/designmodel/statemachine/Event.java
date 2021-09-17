package designmodel.statemachine;

/**
 * 事件
 *
 * @author shengweisong
 * @date 2021-07-27 8:50 PM
 **/
public interface Event {

    WarehousePlanTaskStatusEnum getStatus();
}