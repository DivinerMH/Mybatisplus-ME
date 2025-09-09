package com.menghuan.HuanTools.utils;

import java.net.InetAddress;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自增编码工具
 *
 * @author Administrator
 */
public final class SerializableCodeUtilTest {

    /**
     * 用于存储已生成的编码，检测重复
     */
    private static final Set<String> generatedCodes = Collections.newSetFromMap(new ConcurrentHashMap<>());

    /**
     * 机器标识（取IP末8位）
     */
    private static final String MACHINE_ID = getMachineId();

    private static String getMachineId() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String hostAddress = ip.getHostAddress();
            // 取IP地址最后8位哈希值
            return String.format("%08x", hostAddress.hashCode() & 0xFFFFFFFF);
        } catch (Exception e) {
            // 默认标识
            return "00000000";
        }
    }

    /**
     * 线程安全的编码生成和重复检测
     * 
     * @param generator 编码生成函数
     * @param threadCount 线程数量
     * @param codesPerThread 每个线程生成的编码数量
     * @return 重复编码的数量
     */
    public static int testConcurrentGeneration(java.util.function.Supplier<String> generator, int threadCount,
        int codesPerThread) {
        generatedCodes.clear(); // 清空之前的记录
        AtomicInteger duplicateCount = new AtomicInteger(0);

        // 创建线程池
        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(threadCount);

        // 创建任务
        java.util.List<Runnable> tasks = new java.util.ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            tasks.add(() -> {
                for (int j = 0; j < codesPerThread; j++) {
                    String code = generator.get();
                    if (!generatedCodes.add(code)) {
                        duplicateCount.incrementAndGet();
                        System.err.println("发现重复编码: " + code);
                    }
                }
            });
        }

        // 执行所有任务
        java.util.List<java.util.concurrent.Future<?>> futures = new java.util.ArrayList<>();
        for (Runnable task : tasks) {
            futures.add(executor.submit(task));
        }

        // 等待所有任务完成
        for (java.util.concurrent.Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return duplicateCount.get();
    }

    public static void main(String[] args) {
        System.out.println("开始多线程测试...");
        System.out.println("机器标识: " + MACHINE_ID);

        // 测试 incrementTimeCode
        int threadCount = 16;
        int codesPerThread = 100000;

        long startTime = System.currentTimeMillis();
        int duplicates = testConcurrentGeneration(SerializableCodeUtil::incrementTimeCode, threadCount, codesPerThread);
        long endTime = System.currentTimeMillis();

        System.out.println("测试完成，耗时: " + (endTime - startTime) + "ms");
        System.out.println("生成编码总数: " + (threadCount * codesPerThread));
        System.out.println("发现重复编码数: " + duplicates);
        System.out.println("重复率: " + (duplicates * 100.0 / (threadCount * codesPerThread)) + "%");

        // 测试 incrementMachineTimeCode
        System.out.println("\n开始测试带机器标识的编码生成...");
        startTime = System.currentTimeMillis();
        duplicates =
            testConcurrentGeneration(SerializableCodeUtil::incrementMachineTimeCode, threadCount, codesPerThread);
        endTime = System.currentTimeMillis();

        System.out.println("测试完成，耗时: " + (endTime - startTime) + "ms");
        System.out.println("生成编码总数: " + (threadCount * codesPerThread));
        System.out.println("发现重复编码数: " + duplicates);
        System.out.println("重复率: " + (duplicates * 100.0 / (threadCount * codesPerThread)) + "%");

        // 单线程测试，验证编码顺序
        System.out.println("\n单线程顺序生成示例:");
        for (int i = 0; i < 10; i++) {
            System.out.println("incrementTimeCode() : " + SerializableCodeUtil.incrementTimeCode());
        }
    }

}