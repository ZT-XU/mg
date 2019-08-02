package com.xzt.servlet;

import com.xzt.pojo.User;
import com.xzt.service.UserService;
import com.xzt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    UserService service = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        // 获取信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int age = req.getParameter("age").equals("")?0:Integer.parseInt(req.getParameter("age"));
        String birth = req.getParameter("birth");
        User user = new User(0,uname,pwd,sex,age,birth);
        // 处理请求信息
        // 调用service
        int i = service.userRegister(user);
        if (i > 0)
        {
            // 重定向
            resp.sendRedirect("/mg/login.jsp?flag=3");
        }
    }
}
