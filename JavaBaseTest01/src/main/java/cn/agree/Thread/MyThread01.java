package cn.agree.Thread;

public class MyThread01 extends Thread {

    // 指定线程的名字
    public MyThread01(String name) {
        super(name);
    }

    // 重写run方法

    @Override
    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(getName()+":正在执行!"+i);
        }
    }
}
