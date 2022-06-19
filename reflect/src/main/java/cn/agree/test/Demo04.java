package cn.agree.test;

import cn.agree.pojo.Student;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

/*
*  工厂方法 可以根据配置文件产生任意类型对象
*
* */
public class Demo04 {
    public static void main(String[] args) {

        Student student = (Student) createObj();
        System.out.println(student);
    }

    /*
    *  根据配置文件创建对象
    *
    * */
    public static Object createObj() {
        try {
            // 创建属性集合
            Properties pro = new Properties();
            pro.load(Demo04.class.getResourceAsStream("/stu.properties"));
            System.out.println("-----------------------");
            // System.out.println(pro);
            // 从集合中获取类名
            String className = pro.getProperty("class");
            // 通过反射获取Class对象
            Class c = Class.forName(className);
            // 快速创建对象
            Object obj = c.newInstance();

            // 遍历集合
            Set<String> names = pro.stringPropertyNames();

            for (String name: names) {
                // System.out.println(name);
                if (name.equals("class")) continue;
                // 获取值
                String value = pro.getProperty(name);

                // name 成员变量名
                Field f = c.getDeclaredField(name);
                f.setAccessible(true);
                // 获得成员变量类型
                Class typeClass = f.getType();
                System.out.println(typeClass);
                if (typeClass == int.class) {
                    f.setInt(obj, Integer.parseInt(value));
                } else {
                    f.set(obj, value);
                }

            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



}
