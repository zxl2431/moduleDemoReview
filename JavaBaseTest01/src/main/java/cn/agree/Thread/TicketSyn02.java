package cn.agree.Thread;

public class TicketSyn02 implements Runnable {

    private int ticket = 100;


    @Override
    public void run() {
        while (true) {
            sellTicket();
        }
    }

    /*
     *  所对象 是 谁调用这个方法 就是谁
     *  隐含 锁对象 就是 this
     *
     * */
    public synchronized void sellTicket() {
        if (ticket>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 获取当前线程对象的名称
            String name = Thread.currentThread().getName();
            System.out.println(name+"正在卖:"+ticket--);
        }
    }



}
