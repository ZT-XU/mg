package com.xzt.servlet;

import com.xzt.pojo.User;
import com.xzt.service.UserService;
import com.xzt.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

@WebServlet("/password.do")
public class PasswordServlet extends HttpServlet {
    Logger logger = Logger.getLogger(PasswordServlet.class);
    UserService service = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        User user = ((User) session.getAttribute("user"));
        logger.info(user.getUname() + "修改密码");
        // 获取数据信息
        String newPwd = req.getParameter("newPwd");
        int uid = user.getUid();
        // 处理请求
        // 调用service
        int index = service.userChangePwdService(newPwd,uid);
        if (index > 0)
        {
            logger.info(user.getUname()+"密码修改成功");
        }
        else
            logger.info(user.getUname()+"密码修改失败");
        // 请求转发给Logout服务器
        req.getRequestDispatcher("/logout.do").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
