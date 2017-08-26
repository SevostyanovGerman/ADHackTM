package com.adhack.adhack.services;

import com.adhack.adhack.models.VkAccessToken;
import com.adhack.adhack.repository.VkAccessTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.ServiceMode;

@Service
public class VkServiceImpl implements VkService {

	@Autowired
	private VkAccessTokenRepository vkAccessTokenRepository;

	@Override
	public VkAccessToken getAccessToken(String code) {
		RestTemplate restTemplate = new RestTemplate();
		String queryUrl = "https://oauth.vk.com/access_token?client_id=6162776&client_secret=MYrno1U2gX7p7rT410Zw&redirect_uri=http://b8309721.ngrok.io/ads/vk/auth&code=" + code;
		VkAccessToken vkAccessToken = restTemplate.getForObject(queryUrl, VkAccessToken.class);
		System.out.println(vkAccessToken);
		return vkAccessToken;
	}

	@Override
	public void saveAccessToken(VkAccessToken vkAccessToken) {
		vkAccessToken.setId(-1L);
		vkAccessTokenRepository.save(vkAccessToken);
	}
}
