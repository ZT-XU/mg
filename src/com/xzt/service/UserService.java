package com.xzt.service;

import com.xzt.pojo.User;

import java.util.List;

public interface UserService {
    // 处理登录
    User checkUserLoginService(String uname, String pwd);
    // 处理修改密码
    int userChangePwdService(String newPwd, int uid);
    // 输出所有用户信息
    List<User> showUserService();
    // 注册
    int userRegister(User user);
}
