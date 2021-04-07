package loadbalance;

import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Map;

/**
 * 负载均衡抽象基类
 *
 * @author shengweisong
 * @date 2021-04-07 2:04 PM
 **/
public class AbstractLoadBalance {

    // 待路由的Ip列表，Key代表Ip，Value代表该Ip的权重
    private static final Map<String, Integer> serverWeightMap =
            Maps.newConcurrentMap();

    static {
//        serverWeightMap.put("192.168.1.100", 1000);
//        serverWeightMap.put("192.168.1.101", 1000);
        // 权重为4
        serverWeightMap.put("192.168.1.102", 4000);
//        serverWeightMap.put("192.168.1.103", 1000);
//        serverWeightMap.put("192.168.1.104", 1000);
        // 权重为3
        serverWeightMap.put("192.168.1.105", 3000);
//        serverWeightMap.put("192.168.1.106", 1000);
        // 权重为2
        serverWeightMap.put("192.168.1.107", 2000);
        serverWeightMap.put("192.168.1.108", 1000);
//        serverWeightMap.put("192.168.1.109", 1000);
//        serverWeightMap.put("192.168.1.110", 1000);
    }

    /**
     * 获取ip列表
     */
    protected List<String> ipList() {
        return Lists.newArrayList(serverWeightMap.keySet());
    }


    protected static Map<String, Integer> getServerWeightMap() {
        return serverWeightMap;
    }
}