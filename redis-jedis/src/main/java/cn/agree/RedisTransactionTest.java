package cn.agree;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTransactionTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.234.128", 6379);
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Mr.zhang");
        jsonObject.put("age", "16");
        String result = jsonObject.toJSONString();
        // System.out.println(result);
        // 开启事物
        Transaction multi = jedis.multi();
        // jedis.watch(result);

        try {
            multi.set("user1", result);
            multi.set("user2", result);
            int i = 1/0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }



    }
}
