package demo;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestIOError {

    @Test
    public void testIO() throws IOException, InterruptedException {

        for (int i = 0; i < 1000; i++) {
            DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("/tmp"));
//            paths.close();
        }

        Thread.sleep(300000);

    }
}
