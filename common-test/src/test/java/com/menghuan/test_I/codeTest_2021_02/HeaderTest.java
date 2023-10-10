package com.menghuan.test_I.codeTest_2021_02;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HeaderTest {

    public static void main(String[] args) {
        // new HeaderTest().downloadHtml("http://www.bilibili.com");
        new HeaderTest().downloadHtml("http://192.168.1.163:8080/login?timedOut=true");

    }

    public void downloadHtml(String link) {
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            URL url = new URL(link);
            URLConnection con = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            writer = new FileWriter("f://test1.txt");
            String buff = null;
            StringBuilder sb = new StringBuilder();
            while ((buff = reader.readLine()) != null) {
                writer.write(buff);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
