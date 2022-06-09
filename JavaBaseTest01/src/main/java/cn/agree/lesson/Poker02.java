package cn.agree.lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Poker02 {
    public static void main(String[] args) {
        //
        HashMap<Integer, String> pokerMap = new HashMap<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        //使用Collections工具类的addAll方法
        Collections.addAll(colors, "♦", "♣", "♥", "♠");
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int count = 1;

        pokerMap.put(count++, "大王");
        pokerMap.put(count++, "小王");

        for (String number : numbers) {
            for (String color : colors) {
                String card = color + number;
                pokerMap.put(count++, card);
            }
        }

        // pokerMap整好了

        // 洗牌 Set集合和List集合的转换
        Set<Integer> numberSet = pokerMap.keySet();
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.addAll(numberSet);
        // sort方法只能是List 参数
        Collections.sort(numberList);


        // 三个玩家
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        // 发牌
        for (int i=0; i<numberList.size(); i++) {
            Integer no = numberList.get(i);

            if (i>=51) {
                dipai.add(no);
            } else {
                if (i % 3 == 0) { player01.add(no); }
                else if (i % 3 == 1) { player02.add(no); }
                else { player03.add(no); }
            }
        }

        // 各自按顺序捋牌
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(dipai);

        ArrayList<String> play01_ = new ArrayList<>();
        ArrayList<String> play02_ = new ArrayList<>();
        ArrayList<String> play03_ = new ArrayList<>();
        ArrayList<String> dipai_ = new ArrayList<>();
        // 序号和牌面的转换
        for (Integer i : player01) {
            String card = pokerMap.get(i);
            play01_.add(card);
        }

        for (Integer i : player02) {
            String card = pokerMap.get(i);
            play02_.add(card);
        }

        for (Integer i : player03) {
            String card = pokerMap.get(i);
            play03_.add(card);
        }

        for (Integer i : dipai) {
            String card = pokerMap.get(i);
            dipai_.add(card);
        }

        System.out.println("player01_"+play01_);
        System.out.println("player02_"+play02_);
        System.out.println("player03_"+play03_);
        System.out.println("dipai_"+dipai_);





    }
}
