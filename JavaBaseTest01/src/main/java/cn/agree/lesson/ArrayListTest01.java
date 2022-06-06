package cn.agree.lesson;

import cn.agree.pojo.Student;

import java.util.ArrayList;

public class ArrayListTest01 {
    public static void main(String[] args) {

        // 创建一个学生数组
        Student[] stus = new Student[3];

        // 创建学生对象
        Student s1 = new Student("曹操",40);
        Student s2 = new Student("刘备",35);
        Student s3 = new Student("孙权",30);

        // 数组赋值
        stus[0] = s1;
        stus[1] = s2;
        stus[2] = s3;

        for (int i=0; i<stus.length; i++) {
            Student s = stus[i];
            System.out.println(s);
        }

        System.out.println("------------------------------------");

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);



        System.out.println(list);



    }
}
