package designmodel.statemachine;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Set;

/**
 * Transition实现
 *
 * @author shengweisong
 * @date 2021-07-27 9:25 PM
 **/
@Data
public class TransitionImpl<E extends Event> {

    private Set<WarehousePlanTaskStatusEnum> canTransferToStates;

    private WarehousePlanTaskStatusEnum sourceState;

    private Class<E> event;

    private EventHandler<E> eventHandler;

//    public TransitionImpl(Set<WarehousePlanTaskStatusEnum> canTransferToStates,
//                          WarehousePlanTaskStatusEnum sourceState,
//                          Event event,
//                          EventHandler eventHandler) {
//        this.canTransferToStates = canTransferToStates;
//
//        this.sourceState = sourceState;
//
//        this.event = event;
//
//        this.eventHandler = eventHandler;
//    }
//
//    /**
//     * 可以转换到对应状态的列表.
//     *
//     * @return
//     */
//    @Override
//    public Set<WarehousePlanTaskStatusEnum> getCanTransferToStates() {
//        return canTransferToStates;
//    }
//
//    /**
//     * 获取sourceState
//     *
//     * @return
//     */
//    @Override
//    public WarehousePlanTaskStatusEnum getSourceState() {
//        return sourceState;
//    }
//
//    /**
//     * 获取事件
//     */
//    @Override
//    public Class<? extends Event> getEvent() {
//        return event;
//    }
//
//    /**
//     * 获取事件处理器.
//     */
//    @Override
//    public EventHandler getEventHandler() {
//        return eventHandler;
//    }
}