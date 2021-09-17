package designmodel.statemachine;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;

/**
 * @author shengweisong
 * @date 2021-07-27 9:47 PM
 **/
@Slf4j
public class FiniteStateMachineImpl implements FiniteStateMachine {

    private Map<WarehousePlanTaskStatusEnum, Transition> statusEnumTransitionMap = Maps.newConcurrentMap();

    /**
     * 注册
     *
     * @param transition
     */
    public void registerTransition(Transition transition) {
        statusEnumTransitionMap.put(transition.getSourceState(), transition);
    }

    @Override
    public void fire(WarehousePlanTaskStatusEnum sourceStatus, Event event) {
        /**
         * 1. 获取事件管理的transition。
         * 2. 判断sourceStatus 有没有相关的时间. transition
         * 3. 根据event获取eventHandler
         */
        Transition transition = statusEnumTransitionMap.get(event.getStatus());

        if (transition.getCanTransferToStates().contains(event.getStatus())) {
            log.info("source:[{}]->target:[{}]", sourceStatus, event.getStatus());

            transition.getEventHandler().doHandlerEvent(event);
        } else {
            log.info("source:[{}] can't transTo target:[{}]", sourceStatus, event.getStatus());

        }

    }
}