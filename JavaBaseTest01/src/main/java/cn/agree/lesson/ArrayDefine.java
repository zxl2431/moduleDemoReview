package cn.agree.lesson;

public class ArrayDefine {
    public static void main(String[] args) {
        System.out.println("ctrl+Y是删除这一行");
        System.out.println("ctrl+D是复制这一行");

        // 数组定义的三种方式
        int[] arr1 = new int[3]; // 方式一

        int[] arr2 = new int[]{1, 2, 3, 4, 5};  // 方式二

        int[] arr3 = {1, 2, 3, 4, 5, 6};   //方式三

        System.out.println("arr1的长度:"+arr1.length+". arr2的长度:"+arr2.length+". arr3的长度:"+ arr3.length);


    }
}
