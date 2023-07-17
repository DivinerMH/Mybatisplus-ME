package java.com.menghuan.menghuan.designPattern.strategyPattern;

import com.menghuan.designPattern.Receipt;

/**
 * @Author: menghuan
 * @Date: 2021/5/7 10:54
 */
public class Mt8104ReceiptHandleStrategy implements IReceiptHandleStrategy {

    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT8104:" + receipt.getMessage());
    }

}
