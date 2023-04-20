package com.wsh.dao;

import com.wsh.domain.User;
import com.wsh.utils.Druid_Utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    //从数据库中加载数据
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid_Utils.dataSource());

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<User> findAll(){
        //定义sql语句搜索所有用户
        String sql="select * from user1 ";
        List<User> list;
        try {
            //得到结果List集合
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * 查询某个登录用户
     * @param login_user
     * @return
     */
    @Override
    public User findUser(User login_user) {
        //定义sql语句
        String sql="select * from user where username=? and password=?";
        User user;
        try {
            //得到结果List集合
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login_user.getUsername(), login_user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public void insertUser(User user) {
        String sql="Insert into user1 values(null,?,?,?,?,?,?,null,null)";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    /**
     * 删除某个id的数据
     * @param id
     */
    @Override
    public void deleteUser(int id) {
        String sql="delete from user1 where id=?";
        jdbcTemplate.update(sql,id);
    }

    /**
     * 查询某个id的数据
     * @param id
     * @return
     */
    @Override
    public User updateShow(int id) {
        String sql = "select * from user1 where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    /**
     * 修改某个id的数据
     * @param user
     */
    @Override
    public void updateUser(User user) {
        String sql = "update user1 set gender=?,age=?,address=?,qq=?,email=? where id=? ";
        jdbcTemplate.update(sql,user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    /**
     * 获得所有数据的数目
     * @return
     */
    @Override
    public int getTotalCount(Map<String, String[]> parameterMap) {
        //定义基本sql
        String sql = "select count(*) from user1 where 1=1";
        //用来拼接sql
        StringBuilder sb=new StringBuilder();
        sb.append(sql);
        //判断parameterMap是否有数据，有就拼接
        Set<String> keys = parameterMap.keySet();
        //定义一个集合存值对应参数
        List<Object> list = new ArrayList<Object>();
        for (String key : keys) {
            if(key.equals("currentPage") || key.equals("rows")){
                continue;
            }
            String value = parameterMap.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        int count = jdbcTemplate.queryForObject(sb.toString(), Integer.class, list.toArray());
        return count;
    }

    /**
     * 查询从startId开始的row条数据
     * @param startId
     * @param row
     * @return
     */
    @Override
    public List<User> getUserlist(int startId, int row, Map<String, String[]> parameterMap) {
        //定义基本sql
        String sql = "select * from user1 where 1=1";
        //用来拼接sql
        StringBuilder sb=new StringBuilder();
        sb.append(sql);
        //判断parameterMap是否有数据，有就拼接
        Set<String> keys = parameterMap.keySet();
        //定义一个集合存值对应参数
        List<Object> list = new ArrayList<Object>();
        for (String key : keys) {
            String value = parameterMap.get(key)[0];
            if(value != null && !"".equals(value)){
                if(key.equals("currentPage") || key.equals("rows")){
                    continue;
                }
                sb.append(" and "+key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,?");
        list.add(startId);
        list.add(row);
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), list.toArray());
    }
}
