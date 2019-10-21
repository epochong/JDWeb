package com.epochong.servlet;

import com.epochong.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;


@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String email = request.getParameter("email");
        String confirm = request.getParameter("confirm");
        Writer writer = response.getWriter();
        if (CommonUtil.isNull(username,password,password1,email,confirm)) {
            writer.write("<script>\n" +
                    "    alert(\"输入数据不能为空\")\n" +
                    "    window.location(\"register.html\")\n" +
                    "</script>");
        }
        if (!password.equals(password)) {
            writer.write("<script>\n" +
                    "    alert(\"两次密码不一致\")\n" +
                    "    window.location(\"register.html\")\n" +
                    "</script>");
        }
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("password",password);
        response.sendRedirect("login.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
