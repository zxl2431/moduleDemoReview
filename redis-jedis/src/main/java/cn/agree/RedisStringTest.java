package cn.agree;

import redis.clients.jedis.Jedis;

public class RedisStringTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.234.128", 6379);
        // 测试连接
        // System.out.println(jedis.ping());
        jedis.flushDB();

        jedis.set("k1", "v1");
        System.out.println(jedis.get("k1"));
    }
}
