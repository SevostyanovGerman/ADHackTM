package com.adhack.adhack.services;

import com.adhack.adhack.constans.GlobalConstans;
import com.adhack.adhack.models.ListVkCampaign;
import com.adhack.adhack.models.VkAccessToken;
import com.adhack.adhack.models.VkBudgetResponse;
import com.adhack.adhack.models.VkCampaign;
import com.adhack.adhack.repository.VkAccessTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.ServiceMode;
import java.util.Arrays;
import java.util.List;

@Service
public class VkServiceImpl implements VkService {

	@Autowired
	private VkAccessTokenRepository vkAccessTokenRepository;

	@Override
	public VkAccessToken getAccessTokenFirstly(String code) {
		RestTemplate restTemplate = new RestTemplate();
		String queryUrl = "https://oauth.vk.com/access_token?client_id=6162776&client_secret=MYrno1U2gX7p7rT410Zw&redirect_uri=http://b8309721.ngrok.io/ads/vk/auth&code=" + code;
		VkAccessToken vkAccessToken = restTemplate.getForObject(queryUrl, VkAccessToken.class);
		System.out.println(vkAccessToken);
		return vkAccessToken;
	}

	@Override
	public void saveAccessToken(VkAccessToken vkAccessToken) {
		vkAccessToken.setId(1L);
		vkAccessTokenRepository.save(vkAccessToken);
	}

	@Override
	public String getAccessToken() {
		return vkAccessTokenRepository.getOne(1L).getAccess_token();
	}

	@Override
	public ListVkCampaign getVkCampaigns() {
		String params = "account_id=" + GlobalConstans.account_id + "&include_deleted=0";
		String accessToken = getAccessToken();
		String query = GlobalConstans.apiUrl + "ads.getCampaigns?" + params + "&access_token=" + accessToken + "&v=" + GlobalConstans.vkVersion;
		System.out.println(query);
		RestTemplate restTemplate = new RestTemplate();
		ListVkCampaign vkCampaignList = restTemplate.getForObject(query, ListVkCampaign.class);
		return vkCampaignList;
	}

	@Override
	public VkBudgetResponse getVkBudget() {
		String params = "account_id=" + GlobalConstans.account_id;
		String accessToken = getAccessToken();
		String query = GlobalConstans.apiUrl + "ads.getBudget?" + params + "&access_token=" + accessToken + "&v=" + GlobalConstans.vkVersion;
		System.out.println(query);
		RestTemplate restTemplate = new RestTemplate();
		VkBudgetResponse vkBudget = restTemplate.getForObject(query, VkBudgetResponse.class);
		return vkBudget;
	}




}
