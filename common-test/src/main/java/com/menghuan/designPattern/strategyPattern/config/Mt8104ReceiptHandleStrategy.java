package com.menghuan.designPattern.strategyPattern.config;

import com.menghuan.designPattern.strategyPattern.Receipt;

/**
 * 策略接口实现类（具体的处理者）
 * @Author: menghuan
 * @Date: 2021/5/7 10:48
 */
public class Mt8104ReceiptHandleStrategy implements IReceiptHandleStrategy {

    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT8104:" + receipt.getMessage());
    }

}
