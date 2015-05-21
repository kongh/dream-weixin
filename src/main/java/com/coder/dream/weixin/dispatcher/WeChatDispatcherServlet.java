package com.coder.dream.weixin.dispatcher;

import com.coder.dream.weixin.access.WeChatAccessible;
import com.coder.dream.weixin.access.support.DefaultWeChatAccess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ΢������ת��Servlet
 *
 */
public class WeChatDispatcherServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ΢�ż���ǩ��
        String signature = request.getParameter("signature");
        // ʱ���
        String timestamp = request.getParameter("timestamp");
        // �����
        String nonce = request.getParameter("nonce");
        // ����ַ���
        String echostr = request.getParameter("echostr");

        WeChatAccessible accessible = new DefaultWeChatAccess();
        if(accessible.validServerUrl(signature,timestamp,nonce)){
            PrintWriter out = response.getWriter();
            out.print(echostr);
            response.flushBuffer();
            System.out.print("access passed");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder builder = new StringBuilder();
        builder.append("<xml>");
        builder.append("<ToUserName><![CDATA[toUser]]></ToUserName>");
        builder.append("<FromUserName><![CDATA[fromUser]]></FromUserName>");
        builder.append("<CreateTime>12345678</CreateTime>");
        builder.append("<MsgType><![CDATA[text]]></MsgType>");
        builder.append("<Content><![CDATA[���]]></Content>");
        builder.append("</xml>");
        out.print(builder.toString());
        response.flushBuffer();
    }
}
