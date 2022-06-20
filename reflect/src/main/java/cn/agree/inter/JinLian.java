package cn.agree.inter;

public class JinLian implements KindWomen {
    @Override
    public void happyWithMan() {
        System.out.println("JinLian正在Happy...");
    }

    @Override
    public double collect(double money) {
        return money;
    }
}
