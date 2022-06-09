package cn.agree.lesson;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest02 {
    public static void main(String[] args) {
        System.out.println("请录入字符串");

        String line = new Scanner(System.in).nextLine();
        findChar(line);
    }

    private static void findChar(String line) {
        // 哪个字符出现多少次
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<line.length(); i++) {
            Character c = line.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, ++count);
            }
        }

        System.out.println(map);
    }
}
