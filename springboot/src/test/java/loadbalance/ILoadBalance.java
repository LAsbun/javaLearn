package loadbalance;

/**
 * 负载均衡接口
 *
 * @author shengweisong
 * @date 2021-04-07 1:58 PM
 **/
public interface ILoadBalance {

    /**
     * 获取服务ip
     *
     * @return ip
     */
    String getServerIp();
}