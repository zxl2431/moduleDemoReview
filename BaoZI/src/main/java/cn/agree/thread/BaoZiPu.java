package cn.agree.thread;

import cn.agree.pojo.BaoZi;

public class BaoZiPu extends Thread {

    private BaoZi bz;

    public BaoZiPu(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.isFlag() == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("包子铺开始做包子");
                if (count%2 == 0) {
                    bz.setPier("冰片");
                    bz.setXianer("蛋黄");
                }else {
                    bz.setPier("面皮");
                    bz.setXianer("红糖");
                }
                count++;

                bz.setFlag(true);

                System.out.println("包子造好了:"+bz.getPier()+bz.getXianer());

                System.out.println("吃货快来吃吧");

                bz.notify();

            }
        }
    }
}
