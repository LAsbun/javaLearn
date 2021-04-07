package loadbalance;

import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.Map;

/**
 * 加权轮询负载均衡
 *
 * Nginx加权轮询算法
 *
 * 1、概念解释，每个节点有三个权重变量，分别是：
 *
 * (1) weight: 约定权重，即在配置文件或初始化时约定好的每个节点的权重。
 *
 * (2) effectiveWeight: 有效权重，初始化为weight。
 *
 * 在通讯过程中发现节点异常，则-1；
 *
 * 之后再次选取本节点，调用成功一次则+1，直达恢复到weight；
 *
 * 此变量的作用主要是节点异常，降低其权重。
 *
 * (3) currentWeight: 节点当前权重，初始化为0。
 *
 * 2、算法逻辑
 *
 * (1) 轮询所有节点，计算当前状态下所有节点的effectiveWeight之和totalWeight；
 *
 * (2) currentWeight = currentWeight + effectiveWeight; 选出所有节点中currentWeight中最大的一个节点作为选中节点；
 *
 * (3) 选中节点的currentWeight = currentWeight - totalWeight；
 *
 * @author shengweisong
 * @date 2021-04-07 8:39 PM
 **/
public class WeightRoundRibbonLoadBalanceImpl extends AbstractLoadBalance implements ILoadBalance {


    private final static Map<String, Node> nodeMap = Maps.newConcurrentMap();

    static {
        updateNodeMap();
    }

    /**
     * 获取服务ip
     *
     * @return ip
     */
    @Override
    public String getServerIp() {

//        updateNodeMap();


        Integer maxCurWeight = Integer.MIN_VALUE;

        Integer totalEffWeight = 0;

        String chooseServer = null;

        for (Map.Entry<String, Node> entry : nodeMap.entrySet()) {
            String k = entry.getKey();
            Node v = entry.getValue();
            totalEffWeight += v.getEffectiveWeight();
            int tmp = v.getCurrentWeight() + v.getEffectiveWeight();
            v.setCurrentWeight(tmp);
            // 如果tmp > totalEff 那么就可以选中
            if (tmp > maxCurWeight) {
                chooseServer = k;
                maxCurWeight = tmp;

            }

        }
        Node node = nodeMap.get(chooseServer);
        node.setCurrentWeight(node.getCurrentWeight() - totalEffWeight);
        return chooseServer;

    }


    private static void updateNodeMap() {
        Map<String, Integer> serverWeightMap = getServerWeightMap();

//        // 需要移除的serverList
//        Set<String> allNodeSet = nodeMap.keySet();
//        Set<String> newServerSet = serverWeightMap.keySet();
//        allNodeSet.removeAll(newServerSet);
//
//
//        for (String s : allNodeSet) {
//            nodeMap.remove(s);
//        }

        serverWeightMap.forEach((k, v) -> {
            nodeMap.put(k, Node.instanceOf(k, v));
        });

    }

    @Data
    @Builder
    protected static class Node {
        private Integer weight;

        /**
         * 当前有效权重，初始化为weight. 在通讯过程中存在异常
         */
        private Integer effectiveWeight;

        /**
         * 当前节点权重，初始化为0
         */
        private Integer currentWeight;

        private String server;


        public static Node instanceOf(String server, Integer initWeight) {
            return Node.builder().server(server).weight(initWeight).currentWeight(0).effectiveWeight(initWeight).build();
        }
    }

    @Test
    public void testRandom() {
        for (int i = 0; i < 11; i++) {
            System.out.println(getServerIp());
        }
    }
}