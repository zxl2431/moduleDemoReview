package cn.agree.thread;

import cn.agree.pojo.BaoZi;

public class ChiHuo extends Thread{

    private BaoZi bz;

    public ChiHuo(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.isFlag() == false) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃货正在吃包子"+bz.getPier()+bz.getXianer()+"包子");
                bz.setFlag(false);
                bz.notify();
            }
        }
    }
}
