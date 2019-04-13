package com.itany.vo;

import java.io.Serializable;

public class ActionResult implements Serializable{
	
	private String msg;

	
	private Object data;

	private Boolean status;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
