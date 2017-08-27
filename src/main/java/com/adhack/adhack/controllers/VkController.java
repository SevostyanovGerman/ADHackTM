package com.adhack.adhack.controllers;

import com.adhack.adhack.models.*;
import com.adhack.adhack.services.VkService;
import com.adhack.adhack.services.VkServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class VkController {

	private static String code;

	@Autowired
	private VkService vkService;

    @RequestMapping("/")
    public ModelAndView auth(){
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

	@RequestMapping("/ads/vk/createCampaigns")
	public ResponseEntity createCampaigns() throws IOException {
		CampaignSpecification campaignSpecification = new CampaignSpecification();
		campaignSpecification.setType("normal");
		campaignSpecification.setName("java обучение");
		campaignSpecification.setDay_limit("500");
		campaignSpecification.setAll_limit("500");
		campaignSpecification.setStart_time(String.valueOf(System.currentTimeMillis() / 1000000L));
		campaignSpecification.setStop_time(String.valueOf(System.currentTimeMillis() / 1000000L + 10000));
		campaignSpecification.setStatus("0");
		vkService.createCampaigns(campaignSpecification);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/ads/vk/createAds")
	public ResponseEntity createAds() throws Exception {
		AdSpecification adSpecification = new AdSpecification();
		adSpecification.setCpc(vkService.calculateCpc());
		adSpecification.setLink_url("java-mentor.com");
		adSpecification.setPhoto("123");
		adSpecification.setTitle("Java бучение");
		adSpecification.setPhoto(vkService.uploadImg("test2.jpg"));
		vkService.createAds(adSpecification);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/ads/vk/uploadImg")
	public ResponseEntity uploadImg() throws Exception {
		String result = vkService.uploadImg("test2.jpg");
		System.out.println(result);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/ads/vk/getStatistics")
	public ResponseEntity<Object> getStatistics() throws Exception {
		Object jsonObject = vkService.getStatistics();
		System.out.println(jsonObject);
		return new ResponseEntity<>(jsonObject, HttpStatus.OK);
	}





}
