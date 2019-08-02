package com.xzt.dao;

import com.xzt.pojo.User;

import java.util.List;

public interface UserDao {

    User checkUserLoginDao(String uname, String pwd);

    int userChangePwdDao(String newPwd, int uid);

    List<User> showUserDao();

    int userRegisterDao(User user);
}
