package cn.agree.annotest;

import cn.agree.annotation.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = MyTestDemo.class;
        // 获取所有方法
        Method[] methods = c.getMethods();
        Object obj = c.newInstance();

        for (Method m: methods) {
            // 是不是有@MyTest注解
            if (m.isAnnotationPresent(MyTest.class)) {
                // 执行方法
                m.invoke(obj);
            }
        }
    }
}
