package com.wsh.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsh.dao.impl.ProvinceDaoImpl;
import com.wsh.domain.Province;
import com.wsh.service.ProvinceService;
import com.wsh.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //获得ProvinceDaoImpl
    ProvinceDaoImpl provinceDao = new ProvinceDaoImpl();

    @Override
    public List<Province> searchProvince() {
        return provinceDao.searchProvince();
    }

    @Override
    public String findAllJson() {
        //用JedisPoolUtils从JedisPool中获取连接对象
        Jedis jedis = JedisPoolUtils.getJedis();
        //获取数据库中数据
        String provinces = jedis.get("province");
        //判断数据是否存在
        if(provinces==null || provinces.length()==0){
            System.out.println("redis没有有数据，查询数据库。。。。");
            //数据不存在，去mysql数据库中查询
            List<Province> list = provinceDao.searchProvince();
            //将数据变成json数据
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                provinces = objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将数据存入redis中
            jedis.set("province",provinces);
            jedis.close();
        }else {
            System.out.println("redis有数据。。。。");
        }

        return provinces;
    }
}
