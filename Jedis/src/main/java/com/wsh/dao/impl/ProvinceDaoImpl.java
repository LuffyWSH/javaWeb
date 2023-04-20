package com.wsh.dao.impl;

import com.wsh.dao.ProvinceDao;
import com.wsh.domain.Province;
import com.wsh.utils.Druid_Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    //从数据库中加载数据
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_Utils.dataSource());

    @Override
    public List<Province> searchProvince() {
        String sql = "select * from province";

        List<Province> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return list;
    }
}
