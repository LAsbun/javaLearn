package designmodel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class RealSubject extends Subject {

  private List<Observer> observerList = new ArrayList<>();

  @Override
  void add(Observer observer) {
    observerList.add(observer);
  }

  @Override
  void notify(String message) {
    observerList.forEach(k -> {
      k.update(message);
    });
  }
}
