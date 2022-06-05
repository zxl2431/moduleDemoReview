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

        // 数组元素的赋值和修改
        arr1[0] = 5;
        arr1[1] = 6;
        arr1[2] = 7;

        System.out.println(arr1[1]);

        int[] arrtemp = arr1; // 这个arrtemp指向了arr1
        arr1[1] = 88;
        System.out.println(arr1[1]);

        // 数组的常规操作比较简单 记住索引就行了
        // 常见的异常是数组越界异常和空指针异常

        // 但是数组是和算法连接比较紧密的 最数组的最大值 数组的排序 数组的反转

        // 数组名 作为方法参数和返回值


    }
}
