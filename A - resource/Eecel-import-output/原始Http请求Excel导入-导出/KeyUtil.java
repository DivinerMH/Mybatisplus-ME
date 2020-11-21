package com.joolun.cloud.mall.common.util;

import java.util.Random;
import java.util.UUID;


/**
 * @Author: Wong
 * @ClassName: KeyUtil
 * @Date: 2020/11/12 11:38
 * @Description:
 * @Version: V1.0
 **/
public class KeyUtil {

	/**
	 * 生成ID主键
	 * 格式 时间+随机数
	 * @return
	 */
	public static synchronized String genUniqueKey() {
		Random random = new Random();

		Integer number = random.nextInt(900000) + 100000;

		return System.currentTimeMillis() + String.valueOf(number);
	}

	/**
	 * 获取UUID
	 * @return
	 */
	public static synchronized String get32UUID() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}

	public static String random(int len) {
		Random random = new Random();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < len; i++) {
			str.append(random.nextInt(9) + 1);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(KeyUtil.random(4));
		System.out.println(KeyUtil.get32UUID());
	}

}
