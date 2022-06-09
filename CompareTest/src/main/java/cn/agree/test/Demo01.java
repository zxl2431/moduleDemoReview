package cn.agree.test;

import cn.agree.pojo.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();

        list.add(new Student("rose",18));
        list.add(new Student("jack",16));
        list.add(new Student("abc",16));
        list.add(new Student("ace",17));
        list.add(new Student("mark",16));

        /*
        *  按照学生年龄排序
        *  sort方法必须实现 Comparable接口
        *  并重新 compareTo方法
        *
        * */
        Collections.sort(list);

        for (Student stu : list) {
            System.out.println(stu);
        }

        System.out.println("-------------------------------");

        /*
        *  如果想要独立定义比较规则
        *  以学生的年龄降序排列
        *  再首字母升序
        *
        * */
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o2.getAge() - o1.getAge(); // 年龄降序

                if (result == 0) { // 年龄相同 首字母升序
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }

                return result;
            }
        });

        for (Student stu : list) {
            System.out.println(stu);
        }

    }
}
