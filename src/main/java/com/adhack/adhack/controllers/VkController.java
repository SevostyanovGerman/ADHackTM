package com.adhack.adhack.controllers;

import com.adhack.adhack.models.ListVkCampaign;
import com.adhack.adhack.models.VkAccessToken;
import com.adhack.adhack.models.VkBudgetResponse;
import com.adhack.adhack.models.VkCampaign;
import com.adhack.adhack.services.VkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VkController {

	private static String code;

	@Autowired
	private VkService vkService;

    @RequestMapping("/")
    public ModelAndView test(){
        String redUrl = "https://oauth.vk.com/authorize?client_id=6162776&display=popup&redirect_uri=http://b8309721.ngrok.io/ads/vk/auth&scope=ads&response_type=code&v=5.68";
        return new ModelAndView("redirect:" + redUrl);
    }

    @RequestMapping("/ads/vk/auth")
    public ResponseEntity getAccessToken(@RequestParam String code){
    	code = code;
    	VkAccessToken vkAccessToken = vkService.getAccessTokenFirstly(code);
    	vkService.saveAccessToken(vkAccessToken);
        System.out.println(vkAccessToken);
        return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping("/ads/vk/getCampaigns")
	public ResponseEntity<ListVkCampaign> getCampaigns(){
		ListVkCampaign vkCampaigns = vkService.getVkCampaigns();
		return new ResponseEntity<ListVkCampaign>(vkCampaigns, HttpStatus.OK);
	}

	@RequestMapping("/ads/vk/getBudget")
	public ResponseEntity<VkBudgetResponse> getBudget(){
		VkBudgetResponse vkBudget = vkService.getVkBudget();
		return new ResponseEntity<VkBudgetResponse>(vkBudget, HttpStatus.OK);
	}
}
