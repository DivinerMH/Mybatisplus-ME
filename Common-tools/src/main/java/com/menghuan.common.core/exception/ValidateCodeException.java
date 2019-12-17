package com.menghuan.common.core.tools;

/**
 * @author dzl
 * @date 2018年06月22日16:22:15
 */
public class ValidateCodeException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidateCodeException() {
	}

	public ValidateCodeException(String msg) {
		super(msg);
	}
}
