package com.joolun.cloud.mall.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;


/**
 * @Author: Wong
 * @ClassName: BaseController
 * @Date: 2020/11/12 14:56
 * @Description: 基础控制器
 * @Version: V1.0
 **/
public class BaseController {

    public void sendResponseErrorMsg(HttpServletResponse response, Exception e) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(e.getMessage().getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();
            response.flushBuffer();
        } catch (Exception e1) {
            e.printStackTrace();
        }
    }


}
