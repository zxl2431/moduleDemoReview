package cn.agree.Thread;

public class ThreadDemo02 {
    public static void main(String[] args) {
        // 创建自定义类对象 线程任务对象
        MyRunnable mr = new MyRunnable();
        // 创建线程对象
        Thread t = new Thread(mr, "小强");
        t.start();

        // 匿名内部类 创建一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<20; i++) {
                    System.out.println("张宇:"+i);
                }
            }
        }).start();

        for (int i=0; i<20; i++) {
            System.out.println("旺财"+i);
        }


    }
}
