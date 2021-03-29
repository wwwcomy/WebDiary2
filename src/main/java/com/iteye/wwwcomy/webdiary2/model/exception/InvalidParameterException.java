package com.iteye.wwwcomy.webdiary2.model.exception;

/**
 * Indicates that the input parameter is invalid
 *
 */
public class InvalidParameterException extends RuntimeException {
	private static final long serialVersionUID = 2307749167803827788L;

	public InvalidParameterException() {
	}

	public InvalidParameterException(String s) {
		super(s);
	}

	public InvalidParameterException(String s, Throwable e) {
		super(s, e);
	}
}
