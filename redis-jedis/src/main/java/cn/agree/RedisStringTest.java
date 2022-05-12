package cn.agree;

import redis.clients.jedis.Jedis;

public class RedisStringTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.234.128", 6379);
        System.out.println(jedis.ping());
    }
}
