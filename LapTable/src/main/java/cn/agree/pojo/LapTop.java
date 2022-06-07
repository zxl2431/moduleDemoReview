package cn.agree.pojo;

import cn.agree.inter.USB;

public class LapTop {
    // 笔记本开启运行功能
    public void run() {
        System.out.println("笔记本运行");
    }

    //
    public void useUSB(USB usb) {
        if (usb!=null) {
            usb.open();
            //类型转换 调用特有的方法
            if (usb instanceof Mouse) {
                Mouse m = (Mouse) usb;
                m.click();
            } else if (usb instanceof KeyBoard) {
                KeyBoard kb = (KeyBoard) usb;
                kb.type();
            }

            usb.close();
        }
    }

    public void shutDown() {
        System.out.println("笔记本关闭");
    }


}
