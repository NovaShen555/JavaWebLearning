package top.novashen.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.print("HELLO,SYH");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
