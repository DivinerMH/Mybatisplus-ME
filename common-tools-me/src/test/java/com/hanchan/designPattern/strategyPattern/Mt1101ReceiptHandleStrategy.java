package com.hanchan.designPattern.strategyPattern;

import com.hanchan.designPattern.Receipt;

/**
 * @Author: menghuan
 * @Date: 2021/5/7 10:49
 */
public class Mt1101ReceiptHandleStrategy implements IReceiptHandleStrategy {

    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT1101:" + receipt.getMessage());
    }

}
