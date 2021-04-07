package loadbalance;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询法
 *
 * @author shengweisong
 * @date 2021-04-07 2:02 PM
 **/
public class RoundRibbonLoadBalanceImpl extends AbstractLoadBalance implements ILoadBalance {

    private static final AtomicInteger pos = new AtomicInteger(0);

    /**
     * 获取服务ip
     *
     * @return ip
     */
    @Override
    public String getServerIp() {
        List<String> ipList = ipList();
        // 先获取值，然后再自增, 再整除
        int cuePos = incrementAndGetModulo(ipList.size());
        // 这里实际也是需要看是否可以调用，底层服务是否异常等
        return ipList.get(cuePos);
    }


    /**
     * Inspired by the implementation of {@link com.netflix.loadbalancer.RoundRobinRule#incrementAndGetModulo}.
     *
     * @param modulo The modulo to bound the value of the counter.
     * @return The next value.
     */
    private int incrementAndGetModulo(int modulo) {
        for (; ; ) {
            int current = pos.get();
            int next = (current + 1) % modulo;
            if (pos.compareAndSet(current, next))
                return next;
        }
    }

    @Test
    public void testRibbon() {
        for (int i = 0; i < 15; i++) {
            System.out.println(getServerIp());
        }
    }
}