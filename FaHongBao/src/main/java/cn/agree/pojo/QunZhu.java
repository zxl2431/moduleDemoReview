package cn.agree.pojo;

import java.util.ArrayList;

public class QunZhu extends User {

    public QunZhu() {
    }

    public QunZhu(String name, double leftMoney) {
        super(name, leftMoney);
    }

    /*
    *  群主发红包, 就是把一个整数金额 分成若干等份
    *
    *  1,获取余额 看够不够
    *
    *  2、修改余额
    *
    *  3、拆分红包
    *
    * */
    public ArrayList<Double> send(int money, int count) {
        // 获取余额
        double leftMoney = getLeftMoney();

        if (leftMoney < money) {
            return null;
        }
        // 修改余额
        setLeftMoney(leftMoney - money);

        // 创建一个集合 分成若干等份
        ArrayList<Double> list = new ArrayList<>();

        // 扩大100倍
        money = money*100;

        // 每份金额
        int m = money / count;
        // 除的干净不
        int l = money % count;

        // 无论除的干净与否 n-1份都是等额的
        for (int i=0; i<count-1; i++) {
            list.add(m/100.0);
        }

        if (l==0) {
            list.add(m / 100.0);
        } else {
            list.add((m+l)/100.0);
        }

        return list;
    }


}
