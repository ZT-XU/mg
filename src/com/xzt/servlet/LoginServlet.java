package com.xzt.servlet;

import com.xzt.pojo.User;
import com.xzt.service.UserService;
import com.xzt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    private String name;
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        // 调用登录处理方法
        checkUserLogin(req, resp);
    }

    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException,
            ServletException{
        // 获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        // 处理请求信息
        User user = userService.checkUserLoginService(uname, pwd);
        // 响应处理结果
        if (user == null) {
            // 登录失败，重定向到登录页面(绝对路径比较好)
            req.setAttribute("flag",0); // 交给Logout判断请求是哪一个servlet发来的
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        } else {
            // 直接响应
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/mg/main/main.jsp");
        }
        // 请求转发
        // 重定向
    }
}
