package cn.agree.pojo;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {

    public Member() {
    }

    public Member(String name, double leftMoney) {
        super(name, leftMoney);
    }

    // 打开红包 从集合中随机取一份 保存在自己的余额
    public void openHongBao(ArrayList<Double> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        // 移除一个金额
        Double money = list.remove(index);
        setLeftMoney(getLeftMoney()+money);
    }


}
