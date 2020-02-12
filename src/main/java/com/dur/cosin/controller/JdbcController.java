package com.dur.cosin.controller;

import com.dur.cosin.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/users")
    public String getUsers(ModelMap map){
        String sql = "SELECT * FROM zc_kapai_member ORDER BY power DESC LIMIT 10";
        List<User> users = jdbcTemplate.query(sql,new RowMapper<User>(){
            User user = null;
            @Override
            public User mapRow(ResultSet rs,int rowNum) throws SQLException{
                user = new User();
                user.setId(rs.getInt("uid"));
                user.setUserName(rs.getString("nickname"));
                return user;
            }
        });
        for(User user:users){
            System.out.println(user.getId());
            System.out.println(user.getUserName());
        }
        map.addAttribute("users", users);
        return "user";
    }
}
