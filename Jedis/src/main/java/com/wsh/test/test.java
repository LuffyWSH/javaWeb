package com.wsh.test;

import com.wsh.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class test {

    @Test
    //快速入门
    public void test1(){
        //获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //操作
        jedis.set("student","wsh");
        //关闭连接
        jedis.close();
    }

    //使用连接池,快速入门
    @Test
    public void test2(){
        //1、获取连接池
        JedisPool jedisPool = new JedisPool();
        //2、从连接池里获取连接对象
        Jedis jedis = jedisPool.getResource();
        //3、操作
        jedis.set("student1","wsh");
        //4、归还连接对象给连接池
        jedis.close();
    }

    //使用连接池
    @Test
    public void test3(){
        //0、配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        //1、获取连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        //2、从连接池里获取连接对象
        Jedis jedis = jedisPool.getResource();
        //3、操作
        jedis.set("student2","wsh");
        //4、归还连接对象给连接池
        jedis.close();
    }

    //使用连接池工具类
    @Test
    public void test4(){
       //从连接池工具类中获取连接
        Jedis jedis = JedisPoolUtils.getJedis();
        //3、操作
        jedis.set("student3","wsh");
        //4、归还连接对象给连接池
        jedis.close();
    }
}
