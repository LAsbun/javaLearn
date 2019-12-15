package util;

/**
 * Created by louxiu
 */

public class Version {

  //public static String a(Context context) {

  public static String getAppinfo() {
    try {
      //context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      return "android2.4.501";
    } catch (Exception e) {
      return "androiderror";
    }
  }

  public static String getKey() {
    return "op5nb9";
  }
}