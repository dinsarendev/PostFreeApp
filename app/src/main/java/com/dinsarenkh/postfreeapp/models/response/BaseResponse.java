package com.dinsarenkh.postfreeapp.models.response;

import com.google.gson.annotations.SerializedName;

public class BaseResponse <T>{

	@SerializedName("code")
	private String code;

	@SerializedName("data")
	private T data;

	@SerializedName("messageCh")
	private String messageCh;

	@SerializedName("message")
	private String message;

	@SerializedName("messageKh")
	private String messageKh;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessageCh() {
		return messageCh;
	}

	public void setMessageCh(String messageCh) {
		this.messageCh = messageCh;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKh() {
		return messageKh;
	}

	public void setMessageKh(String messageKh) {
		this.messageKh = messageKh;
	}

	@Override
	public String toString() {
		return "BaseResponse{" +
				"code='" + code + '\'' +
				", data=" + data +
				", messageCh='" + messageCh + '\'' +
				", message='" + message + '\'' +
				", messageKh='" + messageKh + '\'' +
				'}';
	}
}