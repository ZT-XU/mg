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
import java.util.List;

@WebServlet("/showuser.do")
public class ShowUserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        // 处理请求
        // 调用service
        List<User> userList = service.showUserService();
        if (userList != null)
        {
            req.setAttribute("userlist",userList);
            // 请求转发
            req.getRequestDispatcher("/user/showUser.jsp").forward(req,resp);
        }
    }
}
