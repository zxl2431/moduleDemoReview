package cn.agree.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSyn03 implements Runnable {
    private int ticket = 100;

    Lock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true) {
            // 锁住
            lock.lock();

            if (ticket>0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 获取当前线程对象的名字
                String name = Thread.currentThread().getName();
                System.out.println(name+"正在卖:"+ticket--);
            }

            // 完事了 解锁
            lock.unlock();


        }

    }
}
