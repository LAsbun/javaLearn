package stacktest;

/**
 * @author
 */
public interface Stack<T> {

  T pop();

  T push(T value);

  boolean empty();

  T peek();

  int size();

}
