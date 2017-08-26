package com.adhack.adhack.services;

import com.adhack.adhack.models.ListVkCampaign;
import com.adhack.adhack.models.VkAccessToken;
import com.adhack.adhack.models.VkBudgetResponse;
import com.adhack.adhack.models.VkCampaign;

import java.util.List;

public interface VkService {
	VkAccessToken getAccessTokenFirstly(String code);
	void saveAccessToken(VkAccessToken vkAccessToken);
	String getAccessToken();
	ListVkCampaign getVkCampaigns();
	VkBudgetResponse getVkBudget();

}
