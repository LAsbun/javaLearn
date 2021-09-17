package designmodel.statemachine;

import java.util.Set;

/**
 * 状态间关系管理器
 *
 * @author shengweisong
 * @date 2021-07-27 9:13 PM
 **/
public interface Transition {

    /**
     * (s1, E) -> (A(eventHandler), s2[是否])
     */

    /**
     * 可以转换到对应状态的列表.
     *
     * @return
     */
    Set<WarehousePlanTaskStatusEnum> getCanTransferToStates();

    /**
     * 获取sourceState
     *
     * @return
     */
    WarehousePlanTaskStatusEnum getSourceState();


    /**
     * 获取事件
     */
    Class<? extends Event> getEvent();

    /**
     * 获取事件处理器.
     */
    EventHandler getEventHandler();

}