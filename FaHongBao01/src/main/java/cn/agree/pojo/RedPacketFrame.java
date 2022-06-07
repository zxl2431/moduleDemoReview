package cn.agree.pojo;



import cn.agree.inter.OpenMode;

import javax.swing.*;

public abstract class RedPacketFrame extends JFrame {

    public String ownerName = "谁谁谁";
    public OpenMode openMode = null;


    /*
    * 构造方法: 生成红包界面
    *
    * */
    public RedPacketFrame(String title) {
        super(title);
        frameInit();    // 页面相关的初始化
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public OpenMode getOpenMode() {
        return openMode;
    }

    public void setOpenMode(OpenMode openMode) {
        this.openMode = openMode;
    }
}
