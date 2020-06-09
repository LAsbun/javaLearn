package io;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by louxiu
 */

public class SpliteFileToTwo {


    @Test
    public void spi() throws FileNotFoundException {

        long l = System.currentTimeMillis();
        try {

            Integer[] aa = new Integer[]{3, 4, 5, 1, 2};
            Arrays.sort(aa);
            System.out.println(StringUtils.join(aa));
//
////            String filePath = "/Users/sws/IdeaProjects/scplatform/scplatform-web/xx.csv";
//            String filePath = "/Users/sws/Downloads/chromeDownloads/rBAxHl5CEFeESyKyAAAAAKiYWs4063.csv";
//            String filePath1 = "/tmp/xx_1.csv";
//            String filePath2 = "/tmp/xx_2.csv";
//            File file = new File(filePath);
//            FileOutputStream outputStream1 = new FileOutputStream(new File(filePath1), true);
//            FileOutputStream outputStream2 = new FileOutputStream(new File(filePath2), true);
//            FileInputStream inputStream = new FileInputStream(file);
//
////            BufferedReader reader = new BufferedReader(new FileReader(filePath));
//            String url = "http://172.16.49.30:8888/group1/M00/00/17/rBAxHl5CEFeESyKyAAAAAKiYWs4063.csv";
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
//            BufferedWriter writer1 = new BufferedWriter(new FileWriter(filePath1, true));
//            BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath2, true));
//
//            String header = reader.readLine();
//            writer1.write(header);
//            writer1.newLine();
//
//            writer2.write(header);
//            writer2.newLine();
//
//            int i = 0;
//            String s = null;
//            while (null != (s = reader.readLine())) {
//                String s1 = s.split(",")[0];
//                System.out.println(s1);
//                if (i % 2 == 0) {
//                    writer1.write(s1);
//                    writer1.newLine();
//                } else {
//                    writer2.write(s1);
//                    writer2.newLine();
//                }
//                ++i;
//            }
//            writer1.flush();
//            writer2.flush();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
        } finally {

        }
//
        System.out.println(System.currentTimeMillis() - l);

    }
}
