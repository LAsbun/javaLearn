package loadbalance;

import com.google.common.collect.Maps;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 随机法
 *
 * @author shengweisong
 * @date 2021-04-07 3:29 PM
 **/
public class RandomLoadBalanceImpl extends AbstractLoadBalance implements ILoadBalance {
    /**
     * 获取服务ip
     *
     * @return ip
     */
    @Override
    public String getServerIp() {
        List<String> ipList = ipList();
        return ipList.get(RandomUtils.nextInt(ipList.size()));
    }

    @Test
    public void testRandom(){
//        for (int i = 0; i < 15; i++) {
//            System.out.println(getServerIp());
//        }

        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("xx", "xx");

        objectObjectHashMap.put("22", objectObjectHashMap);

        System.out.println("");

    }
}