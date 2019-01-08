package com.gayathri.exception;

public class HTTP400Exception extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HTTP400Exception(String string, Exception ex) {
		super(string,ex);
	}

}
