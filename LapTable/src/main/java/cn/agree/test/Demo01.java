package cn.agree.test;

import cn.agree.pojo.KeyBoard;
import cn.agree.pojo.LapTop;
import cn.agree.pojo.Mouse;

public class Demo01 {
    public static void main(String[] args) {
        LapTop lapTop = new LapTop();

        lapTop.run();

        Mouse mouse = new Mouse();
        lapTop.useUSB(mouse);

        System.out.println("------------------");
        KeyBoard keyBoard = new KeyBoard();
        lapTop.useUSB(keyBoard);

        lapTop.shutDown();
    }
}
