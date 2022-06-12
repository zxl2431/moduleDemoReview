package cn.agree.test;

import cn.agree.pojo.BaoZi;
import cn.agree.thread.BaoZiPu;
import cn.agree.thread.ChiHuo;

public class Demo {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();

        ChiHuo chiHuo = new ChiHuo("吃货", baoZi);
        BaoZiPu baoZiPu = new BaoZiPu("包子铺", baoZi);

        chiHuo.start();
        baoZiPu.start();

    }
}
