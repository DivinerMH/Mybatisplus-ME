package com.menghuan.designPattern.strategyPattern;

import com.menghuan.designPattern.Receipt;
import com.menghuan.designPattern.ReceiptBuilder;

import java.util.List;

/**
 * @Author: menghuan
 * @Date: 2021/5/7 10:55
 */
public class Client {

    public static void main(String[] args) {
        // 模拟回执
        List<Receipt> receiptList = ReceiptBuilder.generateReceiptList();
        // 策略上下文类(策略接口的持有者)
        ReceiptStrategyContext receiptStrategyContext = new ReceiptStrategyContext();

        for (Receipt receipt : receiptList) {
            // 获取并设置策略（未匹配唯一值则返回null）
            IReceiptHandleStrategy receiptHandleStrategy = ReceiptHandleStrategyFactory.getReceiptHandleStrategy(receipt.getType());
            // 设置策略
            receiptStrategyContext.setReceiptHandleStrategy(receiptHandleStrategy);
            // 执行策略(执行条件为：！null)
            receiptStrategyContext.handleReceipt(receipt);
        }
    }

}
