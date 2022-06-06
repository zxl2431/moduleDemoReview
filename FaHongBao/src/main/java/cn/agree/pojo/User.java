package cn.agree.pojo;

public class User {

    private String name;         // 用户名
    private double leftMoney;   // 余额

    public User() {
    }

    public User(String name, double leftMoney) {
        this.name = name;
        this.leftMoney = leftMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", leftMoney=" + leftMoney +
                '}';
    }


}
