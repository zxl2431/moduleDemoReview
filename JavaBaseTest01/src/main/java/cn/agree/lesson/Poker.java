package cn.agree.lesson;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {

        // 1.1 创建牌盒
        ArrayList<String> pokerBox = new ArrayList<String>();
        // 1.2 创建花色
        ArrayList<String> colors = new ArrayList<String>();
        // 1.3 创建数字集合
        ArrayList<String> numbers = new ArrayList<String>();

        // 2.1 花色添加元素
        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");

        // 2.2 给数字添加元素
        for (int i=2; i<=10; i++) {
            numbers.add(i+""); // 数字转字符串
        }

        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        // 3.1 创造牌
        for (String color : colors) {
            for (String number : numbers) {
                String card = color+number;
                // 放到牌盒中
                pokerBox.add(card);
            }
        }

        pokerBox.add("小王");
        pokerBox.add("大王");

        /*
        *  array对象的 Arrays工具的一些方法
        *  Collection 对象的有 Collections工具类的一些方法
        *
        * */
        // 4.洗牌
        Collections.shuffle(pokerBox);

        // 发牌
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();

        ArrayList<String> dipai = new ArrayList<String>();

        for (int i=0; i<pokerBox.size(); i++) {
            String card = pokerBox.get(i);
            if (i>=51) {
                dipai.add(card);
            } else {
                //玩家1 %3 ==0
                if(i%3==0){ player1.add(card); }
                else if(i%3==1){
                    //玩家2
                    player2.add(card);
                }else{
                    //玩家3
                    player3.add(card);
                }
            }
        }

        System.out.println("张三: "+player1);
        System.out.println("李四: "+player2);
        System.out.println("王五: "+player3);
        System.out.println("底牌: "+dipai);



    }
}
