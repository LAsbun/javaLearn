package hadoop;

import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileAlreadyExistsException;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

/**
 * @author: louxiu
 * @create: 20190220 2:05 PM
 */
public class test0 {

  @Test
  public void initHDFS() throws Exception {
    // 1 创建配置
    // new Configuration();的时候，它就会去加载jar包中的hdfs-default.xml
    // 然后再加载classpath下的hdfs-site.xml
    Configuration configuration = new Configuration();

    // 2 设置参数
    // 参数优先级： 1、客户端代码中设置的值  2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
//		configuration.set("fs.defaultFS", "hdfs://hadoop102:8020");
    configuration.set("dfs.replication", "3");

    // 3 获取文件系统
    FileSystem fs = FileSystem.get(configuration);

    // 4 打印文件系统
    System.out.println(fs.toString());
  }

  @Test
  public void initHdfs() throws IOException {
    Configuration configuration = new Configuration();
    configuration.set("fs.defaultFS", "hdfs://0.0.0.0:8021");

    FileSystem fileSystem = FileSystem.get(configuration);
//    fileSystem.create(new Path("/user"));
    fileSystem.copyFromLocalFile(new Path("/tmp/sangfordnscmp.txt"), new Path("/user/sangfordnscmp.txt"));
    fileSystem.close();
  }

  @Test
  public void putFileToHDFS() throws Exception {
    // 1 创建配置信息对象
    Configuration configuration = new Configuration();

    FileSystem fs = FileSystem.get(new URI("hdfs://hadoop001:8021"), configuration, "root");

    fs.delete(new Path("hdfs://hadoop001:8021/users/sws/"));

    try {
      boolean mkdirs = fs.mkdirs(new Path("hdfs://hadoop001:8021/users/sws/"));

      System.out.println("mkdir is " + mkdirs);
    } catch (FileAlreadyExistsException e) {
      System.out.println("mkdir is exists");
    }


    FileStatus[] fileStatuses = fs.listStatus(new Path("hdfs://hadoop001:8021/user"));
    for (FileStatus fileStatus : fileStatuses) {

      System.out.println("1232123"+fileStatus);

    }

    System.out.println("dsadshadsahkjs");
    // 2 要上传的文件所在的本地路径
    Path src = new Path("/tmp/.installer");

    // 3 要上传到hdfs的目标路径
    Path dst = new Path("hdfs://hadoop001:8021/user/sws/.installer");

    // 4 拷贝文件
    fs.copyFromLocalFile(src, dst);
    fs.close();
  }

  @Test
  public void mkdirAtHDFS() throws Exception {
    // 1 创建配置信息对象
    Configuration configuration = new Configuration();

    FileSystem fs = FileSystem.get(new URI("hdfs://127.0.0.1:9000"), configuration, "atguigu");

    //2 创建目录
    fs.mkdirs(new Path("hdfs://127.0.0.1:8020/user/atguigu/output"));
  }

}
