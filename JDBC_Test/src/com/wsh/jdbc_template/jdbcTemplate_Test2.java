package com.wsh.jdbc_template;

import com.wsh.domain.Emp;
import com.wsh.utils.Druid_utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/*
修改1号数据的 salary 为 10000
添加一条记录
删除刚才添加的记录
查询id为1的记录，将其封装为Map集合
查询所有记录，将其封装为List
查询所有记录，将其封装为Emp对象的List集合
查询总记录数
 */
public class jdbcTemplate_Test2 {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        test7();
    }

    //修改1号数据的 salary 为 10000
    private static void test1() {
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //定义sql语句
        String sql ="update emp set salary=10000 where id =?";
        //执行sql语句
        int update = jdbcTemplate.update(sql, 1);
        System.out.println(update);
    }

    //添加一条记录
    private static void test2() {
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //定义sql语句
        String sql ="insert into emp values(null,?,?,?,?,?)";
        //执行sql语句
        int update = jdbcTemplate.update(sql, "沙憎","男",6000,"2001-04-08",2);
        System.out.println(update);
    }

    //删除刚才添加的记录
    private static void test3() {
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //定义sql语句
        String sql ="delete from emp where id=7";
        //执行sql语句
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
    }

    //查询id为1的记录，将其封装为Map集合,查询的结果集长度只能是1
    public static void test4(){
        //定义jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //定义sql语句
        String sql = "select * from emp where id = ?";
        //执行sql语句
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(stringObjectMap);
    }

    //查询所有记录，将其封装为List
    public static void test5(){
        //定义jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //定义sql语句
        String sql = "select * from emp";
        //执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

    //查询所有记录，将其封装为Emp对象的List集合
    public static void test6(){
        //定义jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //定义sql语句
        String sql = "select * from emp";
        //执行sql语句
        //注意，javabean类的数据类型改为引用类
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        System.out.println(query);
    }

    //查询总记录数
    public static void test7(){
        //定义jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_utils.dataSource());
        //定义sql语句
        String sql = "select count(id) from emp ";
        //执行sql语句
        //第二个参数是返回值数据类型
        Long count = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println(count);
    }

}
