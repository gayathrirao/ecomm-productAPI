package com.gayathri.exception;

public class RestAPIExceptionInfo {

	Throwable ex;
	String errorMessage;
	String errorDescription;
	public RestAPIExceptionInfo(Throwable ex, String errorMessage, String errorDescription) {
		this.ex = ex;
		this.errorMessage = errorMessage;
		this.errorDescription = errorDescription;
	}
	
	public RestAPIExceptionInfo(String errorMessage, String errorDescription) {
		this.ex = null;
		this.errorMessage = errorMessage;
		this.errorDescription = errorDescription;
	}
	
	public RestAPIExceptionInfo(String errorMessage) {
		this.ex = null;
		this.errorMessage = errorMessage;
		this.errorDescription = null;
	}

	@Override
	public String toString() {
		return "RestAPIExceptionInfo [ex=" + ex + ", errorMessage=" + errorMessage + ", errorDescription="
				+ errorDescription + "]";
	}

	public Throwable getEx() {
		return ex;
	}

	public void setEx(Throwable ex) {
		this.ex = ex;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
