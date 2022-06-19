package cn.agree.test;

import cn.agree.pojo.Student;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        // test01();
        // test02();
        test03();
    }

    /*
    *  根据参数类型获取public构造方法
    *  还有获取私有构造方法
    *
    * */
    public static void test01() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("---------------test01----------------");
        Class c = Class.forName("cn.agree.pojo.Student");

        // 根据参数类型获取构造方法对象
        Constructor cons = c.getConstructor(String.class, String.class, int.class);
        Student student = (Student) cons.newInstance("张三", "女", 16);
        System.out.println(student);
    }

    /*
    *  获取Class对象Method信息
    *  getMethod()
    *  getDeclaredMethod()
    *  getMethods()
    *  getDeclareMethods()
    *
    * */
    public static void test02() throws Exception {
        Class c = Student.class;

        Student student = (Student) c.newInstance();

        // 获取public修饰的方法
        Method m1 = c.getMethod("sleep", int.class);
        m1.invoke(student, 8);

        // 获取private修饰的方法对象
        Method m2 = c.getDeclaredMethod("eat");
        m2.setAccessible(true);
        m2.invoke(student);
    }

    /*
    *  获取成员变量
    *
    * */
    public static void test03() throws Exception {
        Class c = Student.class;
        Student stu = (Student) c.newInstance();

        Field f1 = c.getDeclaredField("gender");
        f1.setAccessible(true);
        f1.set(stu, "男");

        String gender = (String) f1.get(stu);
        System.out.println("性别:"+gender);

    }




}
