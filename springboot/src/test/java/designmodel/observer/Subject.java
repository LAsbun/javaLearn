package designmodel.observer;

/**
 * @author
 */
abstract class Subject {

  abstract void add(Observer observer);

  abstract void notify(String message);

}
