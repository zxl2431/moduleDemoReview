package cn.agree.inter;

import java.util.ArrayList;

public interface OpenMode {

    /*
    *  totalMoney 总金额 单位是分
    *  count    红包个数
    *
    *  ArrayList<Integer>
    *
    * */
    public abstract ArrayList<Integer> divide(int totalMoney, int count);
}
