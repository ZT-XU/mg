package com.xzt.service.impl;

import com.xzt.dao.UserDao;
import com.xzt.dao.impl.UserDaoimpl;
import com.xzt.pojo.User;
import com.xzt.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDaoService = new UserDaoimpl();
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        logger.debug(uname + "发起登录请求");
        User user = userDaoService.checkUserLoginDao(uname,pwd);
        if (user != null)
        {
            logger.debug(uname + "登录成功");
        }
        else{
            logger.debug(uname + "登录失败");
        }
        return user;
    }

    @Override
    public int userChangePwdService(String newPwd, int uid) {
        return userDaoService.userChangePwdDao(newPwd,uid);
    }

    @Override
    public List<User> showUserService() {
        List<User> userList = userDaoService.showUserDao();
        logger.info("读取所有用户信息");
        return userList;
    }

    @Override
    public int userRegister(User user) {
        logger.info(user.getUname() + "请求注册");
        int i = userDaoService.userRegisterDao(user);
        if (i > 0)
            logger.info(user.getUname() + "注册成功！！！");
        return i;
    }
}
