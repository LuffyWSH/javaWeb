package com.wsh.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsh.dao.impl.ProvinceDaoImpl;
import com.wsh.domain.Province;
import com.wsh.service.impl.ProvinceServiceImpl;
import org.junit.Test;

import java.util.List;

public class testDao {
    @Test
    public void test1(){
        ProvinceDaoImpl provinceDao = new ProvinceDaoImpl();
        List<Province> provinces = provinceDao.searchProvince();
        System.out.println(provinces);
    }

    @Test
    public void test2(){
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        List<Province> provinces = provinceService.searchProvince();
        System.out.println(provinces);
    }
    @Test
    public void test3() throws JsonProcessingException {
        //1、不用接收参数，直接调用service层查询
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        List<Province> provinces = provinceService.searchProvince();
        System.out.println("provinces"+provinces);
        //2、将list集合的java数据变成json数据
        //2.1、创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //2.2、转换
        String string = objectMapper.writeValueAsString(provinces);
        System.out.println(string);
    }

    @Test
    public void test4(){
        //1、不用接收参数，直接调用service层查询
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        String allJson = provinceService.findAllJson();
        System.out.println(allJson);
    }
}
