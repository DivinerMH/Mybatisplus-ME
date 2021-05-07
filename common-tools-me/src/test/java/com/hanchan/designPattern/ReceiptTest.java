package com.hanchan.designPattern;

import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;

import java.util.List;

/**
 * @Author: menghuan
 * @Date: 2021/5/7 10:34
 */
public class ReceiptTest {

    @Test
    public void xxxTest() {
        List<Receipt> receiptList = ReceiptBuilder.generateReceiptList();
        //循环处理
        for (Receipt receipt : receiptList) {
            if (StringUtils.equals("MT2101", receipt.getType())) {
                System.out.println("接收到MT2101回执=====================");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (StringUtils.equals("MT1101", receipt.getType())) {
                System.out.println("接收到MT1101回执=====================");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (StringUtils.equals("MT8104", receipt.getType())) {
                System.out.println("接收到MT8104回执=====================");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (StringUtils.equals("MT9999", receipt.getType())) {
                System.out.println("接收到MT9999回执=====================");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
                System.out.println("推送邮件");
            }
            // ......未来可能还有好多个else if
        }
    }


}
