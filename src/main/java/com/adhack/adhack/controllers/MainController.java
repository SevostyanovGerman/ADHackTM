package com.adhack.adhack.controllers;

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

@Controller
public class MainController {

	@Autowired
	private VkService vkService;

	@RequestMapping(value = "/marketing/start", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<MarketingCompany> startMarketing(MarketingCompany marketingCompany){
		vkService.downloadImageOnDisk(marketingCompany.getPictureLink());
		System.out.println("всё ок");

		return new ResponseEntity<MarketingCompany>(marketingCompany, HttpStatus.OK);
	}
}
