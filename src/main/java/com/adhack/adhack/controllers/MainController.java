package com.adhack.adhack.controllers;

import com.adhack.adhack.models.AdSpecification;
import com.adhack.adhack.models.CampaignSpecification;
import com.adhack.adhack.models.MarketingCompany;
import com.adhack.adhack.services.VkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {

	@Autowired
	private VkService vkService;

	@RequestMapping(value = "/marketing/start", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<MarketingCompany> startMarketing(MarketingCompany marketingCompany) throws Exception {
		vkService.downloadImageOnDisk(marketingCompany.getPictureLink());

		CampaignSpecification campaignSpecification = new CampaignSpecification();
		campaignSpecification.setType("normal");
		campaignSpecification.setName(marketingCompany.getCompanyName());
		campaignSpecification.setDay_limit(String.valueOf(marketingCompany.getLimit()/20));
		campaignSpecification.setAll_limit(String.valueOf(marketingCompany.getLimit()));
		campaignSpecification.setStart_time(String.valueOf(System.currentTimeMillis() / 1000000L));
		campaignSpecification.setStop_time(String.valueOf(System.currentTimeMillis() / 1000000L + 1000000));
		campaignSpecification.setStatus("0");
		vkService.createCampaigns(campaignSpecification);

		AdSpecification adSpecification = new AdSpecification();
		adSpecification.setCpc(vkService.calculateCpc());
		adSpecification.setLink_url(marketingCompany.getTargetLink());
		adSpecification.setPhoto(vkService.uploadImg("test2.jpg"));
		adSpecification.setTitle(marketingCompany.getCompanyName());
		vkService.createAds(adSpecification);

		System.out.println("всё ок");

		return new ResponseEntity<MarketingCompany>(marketingCompany, HttpStatus.OK);
	}
}
