package com.adhack.adhack.services;

import com.adhack.adhack.models.VkAccessToken;

public interface VkService {
	VkAccessToken getAccessToken(String code);
	void saveAccessToken(VkAccessToken vkAccessToken);
}
