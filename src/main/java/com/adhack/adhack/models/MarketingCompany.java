package com.adhack.adhack.models;

import java.util.List;

public class MarketingCompany {
	private String companyName;
	private String domain;
	private String countrie;
	private int citie;
	private String pictureLink;
	private int minAge;
	private int maxAge;
	private int sex;
	private String targetLink;
	private int limit;
	private List<String> markets;
	private String longDescription;
//	private Date endTime;


	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public List<String> getMarkets() {
		return markets;
	}

	public void setMarkets(List<String> markets) {
		this.markets = markets;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCountrie() {
		return countrie;
	}

	public void setCountrie(String countrie) {
		this.countrie = countrie;
	}

	public int getCitie() {
		return citie;
	}

	public void setCitie(int citie) {
		this.citie = citie;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTargetLink() {
		return targetLink;
	}

	public void setTargetLink(String targetLink) {
		this.targetLink = targetLink;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

//	public Date getEndTime() {
//		return endTime;
//	}
//
//	public void setEndTime(Date endTime) {
//		this.endTime = endTime;
//	}


	@Override
	public String toString() {
		return "MarketingCompany{" +
				"companyName='" + companyName + '\'' +
				", domain='" + domain + '\'' +
				", countrie='" + countrie + '\'' +
				", citie='" + citie + '\'' +
				", pictureLink='" + pictureLink + '\'' +
				", minAge=" + minAge +
				", maxAge=" + maxAge +
				", sex=" + sex +
				", targetLink='" + targetLink + '\'' +
				", limit=" + limit +
				'}';
	}

	public CharSequence getLongDescription() {
		return longDescription;
	}

}
