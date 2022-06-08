package cn.agree.lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest01 {
    public static void main(String[] args) {
        /*
        *  Comparator 这是在单列集合的工具类Collections的sort()方法中
        *  开始搞起来的
        *
        *  JAVA提供两种比较的实现方式
        *  一种是Comparable接口去实现
        *  一种是Compartor接口
        *
        *  String类是已经实现了Comparable接口的
        *
        * */
        ArrayList<String> list = new ArrayList<String>();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");

        //排序 默认规则排序
        Collections.sort(list);
        System.out.println(list);

        // 按第一个字母降序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });

        System.out.println(list);

    }
}
