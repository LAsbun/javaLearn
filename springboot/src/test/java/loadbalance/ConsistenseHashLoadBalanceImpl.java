package loadbalance;

import org.junit.Test;

import java.util.List;

/**
 * 一致性哈希负载均衡
 *
 * @author shengweisong
 * @date 2021-04-07 3:34 PM
 **/
public class ConsistenseHashLoadBalanceImpl extends AbstractLoadBalance implements ILoadBalance {
    /**
     * 获取服务ip
     *
     * @return ip
     */
    @Override
    public String getServerIp() {

        /**
         * 通过来源的key计算出同样的hash值，然后再根据ip进行取模（基于底层ipList不变的情况下），或者其他的方式来计算.
         */

        String remoteIp = "127.0.0.1";

        List<String> ipList = ipList();

        return ipList.get(remoteIp.hashCode() % ipList.size());

    }

    @Test
    public void testRandom(){
        for (int i = 0; i < 15; i++) {
            System.out.println(getServerIp());
        }
    }
}