package cn.agree.threadpool;

import cn.agree.Thread.MyRunnable01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建线程池对象 里面可以包括两个线程对象
        ExecutorService service = Executors.newFixedThreadPool(2);
        // 创建Runnable实例对象
        MyRunnable01 myRunnable01 = new MyRunnable01();

        // 从线程池中获取对象, 然后调用MyRunnable中的run()
        service.submit(myRunnable01);

        // 在获取个线程对象
        service.submit(myRunnable01);
        service.submit(myRunnable01);



    }
}
