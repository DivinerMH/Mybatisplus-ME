package com.menghuan.designPattern.strategyPattern;

import com.menghuan.designPattern.Receipt;

/**
 * @Description: 回执处理策略接口
 * @Author: menghuan
 * @Date: 2021/5/7 10:41
 */
public interface IReceiptHandleStrategy {

    /**
     * @description 回执处理
     * @param receipt 回执
     */
    void handleReceipt(Receipt receipt);

}
