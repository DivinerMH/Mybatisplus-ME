package com.menghuan.b3dm;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;

import java.io.*;

/**
 * @Author: menghuan
 * @Date: 2021/12/4 14:15
 */
@Slf4j
public class Batched3DModeAnalysis {

    public static void main(String[] args) {
        log.info("b3dm-数据解析......");
    }

    public static byte[] read(File file) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }finally {
            bf.close();
        }
    }

    public static byte[] read(String bFile) throws IOException{
        return read(new File(bFile).getAbsoluteFile());
    }


    @Test
    public void ccc(){
        try {
            byte[] bt = read("C:\\Users\\Administrator\\Desktop\\SZY\\b3dm\\1.b3dm");
            // System.out.println(bt);
            String s = StringUtils.newStringUtf8(bt);
            System.out.println(s);
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @Test
    public void ddd(){

        // 1、创建一个文件对象
        File file = new File("C:\\Users\\Administrator\\Desktop\\SZY\\b3dm\\1.b3dm");

        // 2、使用字节流对象读入内存

        try {
            InputStream fileIn = new FileInputStream(file);
            //DataInputStream in = new DataInputStream(fileIn);

            // 使用缓存区读入对象效率更快
            BufferedInputStream in = new BufferedInputStream(fileIn);

            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\xxx.txt");
            DataOutputStream dataOut = new DataOutputStream(fileOut);

            // 使用缓存区写入对象效率更快
            //BufferedOutputStream dataOut=new BufferedOutputStream(fileOut);
            int temp;
            while ((temp = in.read()) != -1) {
                dataOut.write(temp);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public  void ceshi() {

        String data = "600000343555031374432354230307B22616464496E666F223A7B227265737" +
                "56C745F636F6465223A222D31222C226572725F636F6465223A224E4545445F524556455253414C222C226572725F6D7367223A2265786368616E67652063757073206572726F72227D7D";
        data = data.substring(data.indexOf("7B22"), data.length());//截取字符串
        log.info("zfr_data:", data);
        data = toStringHex(data);//十六进制转字符串 //{"addInfo":{"result_code":"-1","err_code":"NEED_REVERSAL","err_msg":"exchange cups error"}}
        log.info("zfr_data1:", data);

        JsonObject jsonObject = (JsonObject) new JsonParser().parse(data);  // GSON解析
        log.info("zfr_addInfo:", jsonObject.get("addInfo").getAsJsonObject().get("err_code").getAsString());
    }

    /**
     * 十六进制字符串转换字符串
     * 35353637 ==> 5567
     *
     * @return String
     */
    public static String toStringHex(String s) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }






}
