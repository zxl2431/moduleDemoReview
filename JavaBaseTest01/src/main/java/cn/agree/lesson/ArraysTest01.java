package cn.agree.lesson;

import java.util.Arrays;

public class ArraysTest01 {
    public static void main(String[] args) {
        // 定义int 数组
        int[] arr  =  {2,34,35,4,657,8,69,9};
        System.out.println(arr);

        // 数组转换成字符串
        String s = Arrays.toString(arr);
        System.out.println(s);

        // 数组排序
        System.out.println("排序前:"+Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后:"+Arrays.toString(arr));


    }
}
