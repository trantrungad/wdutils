package com.wedev.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A utilize class contains helper methods for working with files
 *
 * @author TrungT
 **/
public class FileUtils {


    /**
     * Reading file content into byte array
     *
     * @param filePath path of file
     * @return byte array of data of file
     **/
    public static byte[] readFile(String filePath) {

        if (filePath == null) {
            throw new NullPointerException("file path is null");
        }

        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException("file does not exist");
        }

        int size = (int) file.length();
        byte[] bytes = new byte[size];
        BufferedInputStream buf = null;
        try {
            buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            bytes = null;
            e.printStackTrace();
        } catch (IOException e) {
            bytes = null;
            e.printStackTrace();
        } finally {
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bytes;
    }

}
