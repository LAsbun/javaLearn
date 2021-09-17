package designmodel.statemachine;

import java.util.List;
import java.util.Set;

/**
 * 状态机上下文管理器
 *
 * @author shengweisong
 * @date 2021-07-27 9:06 PM
 **/
public interface FiniteStateMachine {

//    /**
//     * 获取终止态列表
//     * @return
//     */
//    Set<WarehousePlanTaskStatusEnum> getFinalWarehousePlanTaskList();

//    Map<WarehousePlanTaskStatusEnum, EventHandler>

    /**
     *
     * @param sourceStatus 原始状态
     * @param event
     */
    void fire(WarehousePlanTaskStatusEnum sourceStatus, Event event);
}