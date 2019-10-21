package com.epochong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        HttpSession session = request.getSession();
        String username = "";
        String password = "";
        Writer writer = response.getWriter();
        String username1 = request.getParameter("username");
        String password1 = request.getParameter("password");
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
            password = (String) session.getAttribute("password");
            if (username1.equals(username) && password1.equals(password)) {
                writer.write("<script>\n" +
                        "    alert(\"用户名密码正确，登录成功！\")\n" +
                        "window.location(\"login.html\")</script>");
            } else {
                writer.write("<script>\n" +
                        "    alert(\"用户名密码错误，登录失败！\")\n" +
                        "window.location(\"register.html\")</script>");
            }
        } else {

            if (username1.equals("ErioY") && password1.equals("a12345")) {
                writer.write("<script>\n" +
                        "    alert(\"用户名密码正确，登录成功！\")\n" +
                        "window.location(\"login.html\")</script>");
            } else {
                writer.write("<script>\n" +
                        "    alert(\"用户名密码错误，登录失败！\")\n" +
                        "window.location(\"login.html\")</script>");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
