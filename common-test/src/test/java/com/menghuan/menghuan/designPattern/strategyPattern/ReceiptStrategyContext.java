package java.com.menghuan.menghuan.designPattern.strategyPattern;

import com.menghuan.designPattern.Receipt;

/**
 * @Description: 策略上下文类(策略接口的持有者)
 * @Author: menghuan
 * @Date: 2021/5/7 10:51
 */
public class ReceiptStrategyContext {

    private IReceiptHandleStrategy receiptHandleStrategy;

    /**
     * 设置策略接口
     * @param receiptHandleStrategy
     */
    public void setReceiptHandleStrategy(IReceiptHandleStrategy receiptHandleStrategy) {
        this.receiptHandleStrategy = receiptHandleStrategy;
    }

    /**
     * @description 回执处理
     * @param receipt 回执
     */
    public void handleReceipt(Receipt receipt){
        if (receiptHandleStrategy != null) {
            receiptHandleStrategy.handleReceipt(receipt);
        }
    }

}
