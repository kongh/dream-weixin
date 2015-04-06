package com.coder.weixin.dispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WeiXinDispatcherServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String echostr = req.getParameter("echostr");
        System.out.println(echostr);
        resp.getOutputStream().println(echostr);
        resp.flushBuffer();
    }
}
