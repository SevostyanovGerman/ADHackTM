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
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

	public static List<MarketingCompany> marketingCompanyStatic = new ArrayList<>();

	static {
		MarketingCompany hookahPacman = new MarketingCompany();
		hookahPacman.setCompanyName("Прямая трансляция в Pacman Lounge");
		hookahPacman.setLimit(12000);
		hookahPacman.setDomain("Кафе, бары, рестораны");
		hookahPacman.setPictureLink("https://pp.userapi.com/c836523/v836523313/f12bd/Oul_e0pB1jI.jpg");
		hookahPacman.setSex(2);
		hookahPacman.setTargetLink("https://vk.com/hookahpacman?ad_id=36252628");
		marketingCompanyStatic.add(hookahPacman);
	}

	@Autowired
	private VkService vkService;

	@RequestMapping(value = "/marketing/start", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<MarketingCompany> startMarketing(MarketingCompany marketingCompany) throws Exception {
		marketingCompanyStatic.add(marketingCompany);
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
		adSpecification.setSex(marketingCompany.getSex());
		adSpecification.setCities(String.valueOf(marketingCompany.getCitie()));
		vkService.createAds(adSpecification);

		System.out.println("всё ок");

		return new ResponseEntity<MarketingCompany>(marketingCompany, HttpStatus.OK);
	}
}
