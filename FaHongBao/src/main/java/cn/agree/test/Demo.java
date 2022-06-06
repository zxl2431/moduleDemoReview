package cn.agree.test;

import cn.agree.pojo.Member;
import cn.agree.pojo.QunZhu;

import java.util.ArrayList;
import java.util.Scanner;


public class Demo {
    public static void main(String[] args) {

        QunZhu qz = new QunZhu("群主", 200);

        // 创建一个键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额:");
        int money = sc.nextInt();
        System.out.println("请输入个数:");
        int count = sc.nextInt();

        // 发红包
        ArrayList<Double> sendList = qz.send(money, count);


        if (sendList == null) {
            System.out.println("余额不足...");
            return;
        }

        Member member1 = new Member("1", 10);
        Member member2 = new Member("2", 20);
        Member member3 = new Member("3", 30);

        member1.openHongBao(sendList);
        member2.openHongBao(sendList);
        member3.openHongBao(sendList);

        System.out.println(qz);
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);



    }
}
