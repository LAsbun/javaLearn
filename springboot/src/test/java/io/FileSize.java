package io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by louxiu
 */

public class FileSize {

    @Test
    public void testReadSizeByInputStream() throws FileNotFoundException {
        FileInputStream x = new FileInputStream("x");
        upload(x);
    }

    private static void upload(InputStream inputStream){

    }

    private static void upload(FileInputStream fileInputStream){

    }
}
