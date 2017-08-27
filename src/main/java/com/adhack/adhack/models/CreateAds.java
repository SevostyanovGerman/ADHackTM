package com.adhack.adhack.models;

import java.io.Serializable;

public class CreateAds implements Serializable {
	private String account_id;
	private String v;
	private String access_token;
	private String data;

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
