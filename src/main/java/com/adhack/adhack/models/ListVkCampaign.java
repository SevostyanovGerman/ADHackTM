package com.adhack.adhack.models;

import java.util.List;

public class ListVkCampaign {

	private List<VkCampaign> response;

	public List<VkCampaign> getResponse() {
		return response;
	}

	public void setResponse(List<VkCampaign> response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ListVkCampaign{" +
				"response=" + response +
				'}';
	}
}
