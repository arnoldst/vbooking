package com.vbooking.util;

public class JMSManagerException extends Exception {
	private static final long serialVersionUID = 1L;

	public JMSManagerException() {
	}

	public JMSManagerException(String message) {
		super(message);
	}

	public JMSManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public JMSManagerException(Throwable cause) {
		super(cause);
	}
}