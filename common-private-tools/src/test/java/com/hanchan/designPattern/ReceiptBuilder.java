package com.hanchan.designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟一个回执生成器
 *
 * @Author: menghuan
 * @Date: 2021/5/7 10:31
 */
public class ReceiptBuilder {

    public static List<Receipt> generateReceiptList() {
        //直接模拟一堆回执对象
        List<Receipt> receiptList = new ArrayList<>();
        receiptList.add(new Receipt("我是MT2101回执喔", "MT2101"));
        receiptList.add(new Receipt("我是MT1101回执喔", "MT1101"));
        receiptList.add(new Receipt("我是MT8104回执喔", "MT8104"));
        receiptList.add(new Receipt("我是MT9999回执喔", "MT9999"));
        receiptList.add(new Receipt("我是MT3000回执喔", "MT3000"));
        receiptList.add(new Receipt("我是MT4000回执喔", "MT4000"));
        return receiptList;
    }

}
