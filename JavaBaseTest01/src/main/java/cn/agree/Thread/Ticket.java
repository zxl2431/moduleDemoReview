package cn.agree.Thread;

public class Ticket implements Runnable {
    private int ticket = 100;

    /*
    *  执行卖票操作
    * */
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 获取当前线程对象的名字
                String name = Thread.currentThread().getName();

                System.out.println(name + "正在卖:"+ticket--);
            }
        }
    }
}
