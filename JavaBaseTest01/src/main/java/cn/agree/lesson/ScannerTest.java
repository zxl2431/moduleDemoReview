package cn.agree.lesson;

import java.util.Random;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {

        // new Scanner的时候会有个InputStream
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        // Scanner对象的方法确实有点多

        System.out.println(i);

        System.out.println("----------------------------------------");

        Random r = new Random();
        // 因为nextInt(是不包括边界的)
        int j = r.nextInt(100) + 1;
        System.out.println(j);

    }
}
