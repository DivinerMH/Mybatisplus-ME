package com.helper.weixin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信核心servlet
 */
public class CoreServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CoreServlet.class);

    /**
     * 确认请求来自微信服务器
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("微信请求接入>>>");
        //获取微信加密签名
        String signature = req.getParameter("signature");
        logger.info("微信签名是: {}", signature);
        //获取时间戳
        String timestamp = req.getParameter("timestamp");
        //获取随机数
        String nonce = req.getParameter("nonce");
        //获取随机字符串
        String echostr = req.getParameter("echostr");

        PrintWriter out = resp.getWriter();
        //判断加密后的字符串和签名是否一样.如果一样表示接入成功
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}

