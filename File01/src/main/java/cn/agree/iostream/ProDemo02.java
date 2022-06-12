package cn.agree.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ProDemo02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\read.txt"));

        Set<String> strings = properties.stringPropertyNames();
        for (String key : strings) {
            System.out.println(key+"---"+properties.getProperty(key));
        }
    }
}
