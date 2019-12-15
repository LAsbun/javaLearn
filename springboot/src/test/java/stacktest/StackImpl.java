package stacktest;

import java.util.Arrays;

/**
 * @author
 */
public class StackImpl implements Stack<String> {

  private String[] storage;

  private int capacity;

  private int count;

  private int loadFactor = 2;

  StackImpl(int capacity) {
    this.storage = new String[capacity];
    this.capacity = capacity;
    this.count = 0;
  }

  StackImpl() {
    this.capacity = 1 << 4;
    this.storage = new String[this.capacity];
    this.count = 0;

  }

  @Override
  public String pop() {
    if (this.empty()) {
      System.out.println("no data");
      return null;
    }
    String data = this.storage[count - 1];
    count -= 1;
    return data;
  }

  @Override
  public String push(String value) {
    if (count == capacity) {
      ensureCapcity();
    }
    this.storage[count] = value;
    this.count += 1;
    return value;
  }

  /**
   * 确保有足够的容量
   */
  private void ensureCapcity() {
    int newCapcity = capacity * loadFactor;
    storage = Arrays.copyOf(storage, newCapcity);
    capacity = newCapcity;
  }

  @Override
  public boolean empty() {
    return this.count == 0;
  }

  @Override
  public String peek() {
    if (this.empty()) {
      System.out.println("no data");
      return null;
    }
    return this.storage[this.count - 1];
  }

  @Override
  public int size() {
    return this.count;
  }
}
