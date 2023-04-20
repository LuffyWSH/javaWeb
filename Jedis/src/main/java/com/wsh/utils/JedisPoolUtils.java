package com.wsh.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class JedisPoolUtils {
    private static JedisPool jedisPool;

    //加载配置文件，配置连接池参数
    static {
        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建Properties对象
        Properties properties = new Properties();
        //关联文件
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //获取数据，设置到连接池配置对象中
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        //初始化连接池
        jedisPool= new JedisPool(jedisPoolConfig,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));

    }

    //获取连接
    public static Jedis getJedis(){
       return jedisPool.getResource();
    }

}
