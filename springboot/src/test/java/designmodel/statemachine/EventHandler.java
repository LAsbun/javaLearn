package designmodel.statemachine;

/**
 * 事件处理器
 *
 * @author shengweisong
 * @date 2021-07-27 8:51 PM
 **/
public interface EventHandler<E extends Event> {

    void doHandlerEvent(E e);
}