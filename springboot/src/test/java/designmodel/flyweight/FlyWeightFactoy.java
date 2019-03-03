package designmodel.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class FlyWeightFactoy {

  private Map<String, FlyWeight> stringFlyWeightMap = new HashMap<>();


  public FlyWeight getFlyweight(String x) {

    FlyWeight flyWeight = stringFlyWeightMap.get(x);
    if (null == flyWeight) {
      flyWeight = new FlyWeightExtends();
      stringFlyWeightMap.put(x, flyWeight);
    }

    return flyWeight;

  }

}
