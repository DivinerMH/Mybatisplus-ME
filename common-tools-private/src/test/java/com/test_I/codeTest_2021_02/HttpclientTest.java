package com.test_I.codeTest_2021_02;


import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: menghuan
 * @Date: 2021/4/8 9:54
 */
public class HttpclientTest {

    public static void main(String[] args) {
        System.out.println(new HttpclientTest().getHtml("http://www.bilibili.com"));
    }

    public String getHtml(String url) {
        String html = null;
        //建立HttpClient类,这是HttpClient的jar包中的一个类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //读取html的流
        BufferedReader reader = null;
        //设置请求信息
        HttpGet getmethod = new HttpGet(url);
        //响应
        HttpResponse response = null;
        //设置代理IP
        HttpHost proxy = new HttpHost("124.88.67.81", 80);
        //设置超时时间
        RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(5000).setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();
        //添加请求头
        getmethod.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        getmethod.setConfig(config);
        try {
            //获得响应
            response = httpclient.execute(getmethod);
            //响应体
            HttpEntity entity = response.getEntity();
            //建立一个读取流
            reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            //读取html
            String buff = null;
            StringBuilder sb = new StringBuilder();
            while ((buff = reader.readLine()) != null) {
                sb.append(buff);
            }
            html = sb.toString();
            System.out.println();
            return html;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("读取异常");
            return null;
        } finally {
            try {
                httpclient.close();
                assert reader != null;
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭资源失败");
            }
        }
        return null;
    }
}
