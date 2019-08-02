package com.xzt.servlet;

import com.xzt.pojo.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
    Logger logger = Logger.getLogger(LogoutServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req,resp);
        resp.sendRedirect("/mg/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post方法过来的是修改密码的方法
        logout(req,resp);
        // 重定向
        resp.sendRedirect("/mg/login.jsp?flag=1");
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // 销毁session
        HttpSession session = req.getSession();
        logger.info(((User)session.getAttribute("user")).getUname() + "注销");
        session.invalidate();
    }
}
