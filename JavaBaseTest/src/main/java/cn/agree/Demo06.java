package cn.agree;

import cn.agree.pojo.Student;

public class Demo06 {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setAge(18);
        stu1.setName("Mr.zhang");

        System.out.println(stu1.getName());
        System.out.println(stu1.getAge());

    }
}
