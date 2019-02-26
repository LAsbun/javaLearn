package designmodel.adapter;

/**
 * @author: louxiu
 * @create: 20190226 9:56 AM
 */
class AdapterTarget implements Target {

  private Adapter adapter;

  public AdapterTarget(Adapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public void show() {
    System.out.println("show");
    adapter.showV2();
  }


}
