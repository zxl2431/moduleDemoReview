package cn.agree.test;

import cn.agree.pojo.Student;


public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Student stu = new Student();

        // 获得Student的Class的对象 方式一
        Class c1 = Student.class;
        System.out.println(c1);

        // 获取Class对象的方式二 getClass() 方法
        Class c2 = stu.getClass();
        System.out.println(c2);

        // 获取Class对象方式三 Class.forName("全限定类名")
        Class c3 = Class.forName("cn.agree.pojo.Student");
        System.out.println(c3);
    }
}
