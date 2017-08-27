package com.adhack.adhack.services;

import com.adhack.adhack.constans.GlobalConstans;
import com.adhack.adhack.models.CampaignSpecification;
import com.adhack.adhack.models.CreateCampaigns;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GsonExample {

    public static void main(String[] args) {

        CampaignSpecification campaignSpecification;
        campaignSpecification = new CampaignSpecification();
        campaignSpecification.setType("normal");
        campaignSpecification.setName("java обучение");
        campaignSpecification.setDay_limit("500");
        campaignSpecification.setAll_limit("500");
        campaignSpecification.setStart_time(String.valueOf(System.currentTimeMillis() / 1000000L));
        campaignSpecification.setStop_time(String.valueOf(System.currentTimeMillis() / 1000L + 10000));
        campaignSpecification.setStatus("0");

        List<CampaignSpecification> campaignSpecifications = new ArrayList<>();
        campaignSpecifications.add(campaignSpecification);

        CreateCampaigns createCampaigns = new CreateCampaigns();
        createCampaigns.setAccount_id(GlobalConstans.account_id);

        //1. Convert object to JSON string
		Gson gson = new Gson();
        String json = gson.toJson(campaignSpecifications);

        createCampaigns.setData(json);

        System.out.println(json);

    }

}