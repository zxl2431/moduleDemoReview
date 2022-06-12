package cn.agree.iostream;

import java.util.Properties;
import java.util.Set;

public class ProDemo01 {
    public static void main(String[] args) {
        // 创建属性集对象
        Properties properties = new Properties();
        // 添加键值对
        properties.setProperty("filename", "a.txt");
        properties.setProperty("length", "209385038");
        properties.setProperty("location", "E:\\a.txt");

        System.out.println(properties);

        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        // 遍历
        Set<String> strings = properties.stringPropertyNames();
        for (String key : strings) {
            System.out.println(key+"---"+properties.getProperty(key));
        }

    }
}
