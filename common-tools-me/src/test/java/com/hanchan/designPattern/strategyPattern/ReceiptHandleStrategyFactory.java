package com.hanchan.designPattern.strategyPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 策略工厂
 * @Author: menghuan
 * @Date: 2021/5/7 10:53
 */
public class ReceiptHandleStrategyFactory {

    /*private ReceiptHandleStrategyFactory(){}*/

    /**
     * 获取回执处理策略 (根据策略类型匹配唯一符合条件的回执处理策略，若无则返回 null)
     * @param receiptType 回执类型(`MT1101、MT2101、MT4101、MT8104、MT8105、MT9999...`)
     * @return 回执处理策略
     */
    /*public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType){
        IReceiptHandleStrategy receiptHandleStrategy = null;
        if (StringUtils.equals("MT2101",receiptType)) {
            receiptHandleStrategy = new Mt2101ReceiptHandleStrategy();
        } else if (StringUtils.equals("MT8104",receiptType)) {
            receiptHandleStrategy = new Mt8104ReceiptHandleStrategy();
        }
        return receiptHandleStrategy;
    }*/

    // =====================================策略模式+Map字典=========================================

    private static Map<String,IReceiptHandleStrategy> receiptHandleStrategyMap;

    static {
        receiptHandleStrategyMap = new HashMap<>();
        receiptHandleStrategyMap.put("MT2101",new Mt2101ReceiptHandleStrategy());
        receiptHandleStrategyMap.put("MT8104",new Mt8104ReceiptHandleStrategy());
    }

    /**
     * TODO 为什么此类赋值失效，实际调用时显示空指针（待处理）
     */
    private ReceiptHandleStrategyFactory(){
        /*this.receiptHandleStrategyMap = new HashMap<>();
        this.receiptHandleStrategyMap.put("MT2101",new Mt2101ReceiptHandleStrategy());
        this.receiptHandleStrategyMap.put("MT8104",new Mt8104ReceiptHandleStrategy());*/
    }

    /**
     * 获取回执处理策略 (根据策略类型匹配唯一符合条件的回执处理策略，若无则返回 null)
     * @param receiptType 回执类型(`MT1101、MT2101、MT4101、MT8104、MT8105、MT9999...`)
     * @return 回执处理策略
     */
    public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType){
        // System.out.println("Map:" + receiptHandleStrategyMap);
        return receiptHandleStrategyMap.get(receiptType);
    }




}
