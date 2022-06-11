package cn.agree.Thread;

public class ThreadWaiting01 extends Thread {

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            if (i%10 ==0) {
                System.out.println("----------"+i);
            }
            System.out.println(i);
            try {
                Thread.sleep(1000);
                System.out.println("线程休眠1秒\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new ThreadWaiting01().start();
    }
}
