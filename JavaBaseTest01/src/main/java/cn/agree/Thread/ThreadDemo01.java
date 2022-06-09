package cn.agree.Thread;

public class ThreadDemo01 {
    public static void main(String[] args) {
        /*
        *  创建线程的三种方式
        *
        * */

        System.out.println("---------创建线程的方式一: 继承Thread--------------");
        MyThread01 mt01 = new MyThread01("新的线程");
        // 开启线程
        mt01.start();
        // 主线程
        for (int i=0; i<10; i++) {
            System.out.println("main线程!"+i);
        }
    }
}
