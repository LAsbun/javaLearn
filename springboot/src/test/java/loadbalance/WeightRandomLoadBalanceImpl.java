package loadbalance;

import org.apache.commons.lang.math.RandomUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加权随机负载均衡算法
 *
 * @author shengweisong
 * @date 2021-04-07 4:36 PM
 **/
public class WeightRandomLoadBalanceImpl extends AbstractLoadBalance implements ILoadBalance {
    /**
     * 获取服务ip
     * <p>
     * 参考: {@link com.netflix.loadbalancer.WeightedResponseTimeRule.ServerWeight#maintainWeights}
     * 参考: {@link com.netflix.loadbalancer.WeightedResponseTimeRule#choose}
     * <p>
     * 根据权重以及服务器的数量划分一条线上面的不同的线段，权重就是线段的长度，随机选择线段上面的某个点,落在那个线段里面，就是需要选第几个服务器.
     * 1(A)，2(B)，4(C). 总长度7.其中
     * 0~1 -> 1 (1=A)
     * 1~3 -> 2 (3=A+B)
     * 3-7 -> 4 (7=A+B+C)
     *
     * @return ip
     */
    @Override
    public String getServerIp() {

        Map<String, Integer> serverWeightMap = getServerWeightMap();

        AtomicInteger totalCount = new AtomicInteger();

        List<Integer> serverWeightList = Lists.newArrayList();
        List<String> serverWeightStringList = Lists.newArrayList();

        serverWeightMap.forEach((k, v) -> {
            totalCount.addAndGet(v);
            serverWeightList.add(totalCount.get());
            serverWeightStringList.add(k);
        });

        int rankNum = RandomUtils.nextInt(totalCount.get()) + 1;
        int index = 0;
        for (Integer integer : serverWeightList) {
            if (rankNum <= integer) {
                // 标识命中区间了
                break;
            } else {
                ++index;
            }
        }
        return serverWeightStringList.get(index);
    }

    @Test
    public void ss() {
        for (int i = 0; i < 15; i++) {
            System.out.println(getServerIp());
        }
    }
}