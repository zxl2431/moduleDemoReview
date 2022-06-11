package cn.agree.Thread;

public class TicketSyn01 implements Runnable {
    /*
    * 为了保证每个线程都能正常执行原子操作, JAVA引入了线程同步机制
    * 三种方式
    * 1、同步代码块
    * 2、同步方法
    * 3、锁机制
    *
    *
    * */
    private int ticket = 100;

    Object lock = new Object();


    @Override
    public void run() {
        //每个窗口卖票的操作 永远开启
        while (true) {
            synchronized (lock) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String name = Thread.currentThread().getName();
                    System.out.println(name+"正在卖:"+ticket--);

                }
            }
        }

    }
}
