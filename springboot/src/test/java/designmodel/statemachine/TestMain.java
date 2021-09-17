package designmodel.statemachine;

import com.google.common.collect.Sets;
import org.assertj.core.util.Maps;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TestMain
 *
 * @author shengweisong
 * @date 2021-07-27 9:39 PM
 **/
public class TestMain {

    public static void main(String[] args) {
        Map<WarehousePlanTaskStatusEnum, Set<WarehousePlanTaskStatusEnum>> stateMap = new HashMap<>();

        stateMap.put(WarehousePlanTaskStatusEnum.INIT, Sets.newHashSet(WarehousePlanTaskStatusEnum.FAILED, WarehousePlanTaskStatusEnum.QUEUEING));




        TransitionImpl<Event> eventTransition = new TransitionImpl<>();
//        eventTransition.setEvent();

        System.out.println(new BigDecimal("108.795975").setScale(5, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(new BigDecimal(108.795975).setScale(5, BigDecimal.ROUND_HALF_EVEN));

    }
}