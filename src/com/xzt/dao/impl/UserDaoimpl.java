package com.xzt.dao.impl;

import com.xzt.dao.UserDao;
import com.xzt.pojo.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoimpl implements UserDao {
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manger?serverTimezone=GMT%2B8" +
                    "", "root", "qwe523340");
            ps = conn.prepareStatement("SELECT * FROM t_user WHERE uname=? AND pwd=?");
            ps.setString(1,uname);
            ps.setString(2,pwd);
            System.out.println(uname + pwd);
            rs = ps.executeQuery();
            while (rs.next())
            {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setBirth(rs.getString("birth"));
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int userChangePwdDao(String newPwd, int uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manger?serverTimezone=GMT%2B8" +
                    "", "root", "qwe523340");
            ps = conn.prepareStatement("UPDATE t_user set pwd=? where uid=?");
            ps.setString(1,newPwd);
            ps.setInt(2,uid);
            index = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }

    @Override
    public List<User> showUserDao() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manger?serverTimezone=GMT%2B8" +
                    "", "root", "qwe523340");
            ps = conn.prepareStatement("SELECT * FROM t_user");
            rs = ps.executeQuery();
            while (rs.next())
            {
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setBirth(rs.getString("birth"));
                userList.add(user);
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public int userRegisterDao(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manger?serverTimezone=GMT%2B8" +
                    "", "root", "qwe523340");
            ps = conn.prepareStatement("insert into t_user values(default,?,?,?,?,?)");
            ps.setString(1,user.getUname());
            ps.setString(2,user.getPwd());
            ps.setString(3,user.getSex());
            ps.setInt(4,user.getAge());
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date date = format.parse(user.getBirth());
            java.sql.Date d = new java.sql.Date(date.getTime());
            ps.setDate(5,d);
            index = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;

    }
}
