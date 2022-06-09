package cn.agree.lesson;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest01 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        // 添加元素到集合
        map.put("胡歌", "霍建华");
        map.put("郭德纲", "于谦");
        map.put("薛之谦", "大张伟");

        /*
        *  map的遍历
        *  两种方式
        *  key的set集合
        *  Entry<K,V>的set集合
        *
        * */
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + ":"+map.get(key));
        }

        System.out.println("------------------");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry: entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }


    }
}
