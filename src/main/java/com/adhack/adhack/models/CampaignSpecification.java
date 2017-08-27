package com.adhack.adhack.models;

import java.io.Serializable;

public class CampaignSpecification implements Serializable{

	private String type;
	private String name;
	private String day_limit;
	private String all_limit;
	private String start_time;
	private String stop_time;
	private String status;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay_limit() {
		return day_limit;
	}

	public void setDay_limit(String day_limit) {
		this.day_limit = day_limit;
	}

	public String getAll_limit() {
		return all_limit;
	}

	public void setAll_limit(String all_limit) {
		this.all_limit = all_limit;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getStop_time() {
		return stop_time;
	}

	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
