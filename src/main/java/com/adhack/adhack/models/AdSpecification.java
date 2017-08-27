package com.adhack.adhack.models;

public class AdSpecification {

	private String campaign_id;
	private final int ad_format = 2;
	private final int cost_type = 0;
	private int cpc;
	private String ad_platform = "1";
	private String title;
	private String link_url;
	private String photo;
	private int sex;
	private String cities;

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}

	public int getAd_format() {
		return ad_format;
	}

	public int getCost_type() {
		return cost_type;
	}

	public int getCpc() {
		return cpc;
	}

	public void setCpc(int cpc) {
		this.cpc = cpc;
	}

	public String getAd_platform() {
		return ad_platform;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


}
