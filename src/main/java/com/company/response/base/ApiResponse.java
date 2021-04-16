package com.company.response.base;


import java.io.Serializable;
import java.util.Date;

public abstract class ApiResponse implements Serializable {

	private Long timestamp;
	protected Boolean success;

	protected Integer status;

	protected String message;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiResponse(Boolean success){
		this.timestamp = new Date().getTime();
		this.success = success;

	}


}
