package com.adhack.adhack.services;

import com.adhack.adhack.models.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public interface VkService {
	VkAccessToken getAccessTokenFirstly(String code);
	void saveAccessToken(VkAccessToken vkAccessToken);
	String getAccessToken();
	ListVkCampaign getVkCampaigns();
	VkBudgetResponse getVkBudget();
	void createCampaigns(CampaignSpecification campaignSpecification) throws IOException;
	void createAds(AdSpecification adSpecification) throws IOException;
	int calculateCpc();
	String uploadImg(String imagePath) throws Exception;
	void downloadImageOnDisk(String stringUrl);
	Object getStatistics();
}
