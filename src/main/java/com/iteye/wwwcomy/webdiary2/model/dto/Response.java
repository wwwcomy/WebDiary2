package com.iteye.wwwcomy.webdiary2.model.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class Response<T> {

	private String status;
	private String statusCode;
	private String message;
	private T resultData;
	private Map<String, String> error;

	public Response() {
	}

	/**
	 * @param status
	 * @param statusCode
	 * @param message
	 * @param resultData
	 */
	public Response(String status, String statusCode, String message, T resultData) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.resultData = resultData;
	}

	/**
	 * @param status
	 * @param httpStatus
	 * @param message
	 * @param resultData
	 */
	public Response(String status, HttpStatus httpStatus, String message, T resultData) {
		super();
		this.status = status;
		this.statusCode = String.valueOf(httpStatus.value());
		this.message = message;
		this.resultData = resultData;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return " [" + status + "\t " + statusCode + "\t " + message + "\t " + resultData + "\t " + error + "]";
	}

}