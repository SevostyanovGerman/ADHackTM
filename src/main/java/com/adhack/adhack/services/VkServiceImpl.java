package com.adhack.adhack.services;

import com.adhack.adhack.constans.GlobalConstans;
import com.adhack.adhack.models.*;
import com.adhack.adhack.repository.VkAccessTokenRepository;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class VkServiceImpl implements VkService {

	public static String camplaintId;

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

	@Override
	public void createCampaigns(CampaignSpecification campaignSpecification) throws IOException {
		String accessToken = getAccessToken();
		String query = "https://api.vk.com/method/ads.createCampaigns";

		List<CampaignSpecification> campaignSpecifications = new ArrayList<>();
		campaignSpecifications.add(campaignSpecification);
//
//		CreateCampaigns createCampaigns = new CreateCampaigns();
//		createCampaigns.setV(GlobalConstans.vkVersion);
//		createCampaigns.setAccess_token(accessToken);
//		createCampaigns.setAccount_id(GlobalConstans.account_id);

		Gson gson = new Gson();
		String json = gson.toJson(campaignSpecifications);
//
//		createCampaigns.setData(json);
//
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<CreateCampaigns> request = new HttpEntity<>(createCampaigns);
//		Object o = restTemplate.postForObject(query, request, Object.class);
//		System.out.println(request);

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			HttpPost httpPost = new HttpPost(query);
			ArrayList<NameValuePair> postParameters;
			postParameters = new ArrayList<NameValuePair>();
			postParameters.add(new BasicNameValuePair("account_id", GlobalConstans.account_id));
			postParameters.add(new BasicNameValuePair("v", GlobalConstans.vkVersion));
			postParameters.add(new BasicNameValuePair("access_token", accessToken));
			postParameters.add(new BasicNameValuePair("data", json));
			httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
			CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
			InputStream inputStream = closeableHttpResponse.getEntity().getContent();
			String theString = IOUtils.toString(inputStream, "UTF-8");
			System.out.println(theString);
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(theString);
			if (m.find()) {
				camplaintId = m.group();
			} else {
				System.out.println("всё по пизде пошло");
			}
// handle response here...
		} catch (Exception ex) {
			// handle exception here
		} finally {
			httpClient.close();
		}

	}


	@Override
	public void createAds(AdSpecification adSpecification) throws IOException {

		adSpecification.setCampaign_id(VkServiceImpl.camplaintId); //todo нет валидации
		String accessToken = getAccessToken();
		String query = "https://api.vk.com/method/ads.createAds";

//		CreateAds createAds = new CreateAds();
//		createAds.setV(GlobalConstans.vkVersion);
//		createAds.setAccess_token(accessToken);
//		createAds.setAccount_id(GlobalConstans.account_id);

		Gson gson = new Gson();
		String json = "[" + gson.toJson(adSpecification) + "]";

//		createAds.setData(json);

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			HttpPost httpPost = new HttpPost(query);
			ArrayList<NameValuePair> postParameters;
			postParameters = new ArrayList<NameValuePair>();
			postParameters.add(new BasicNameValuePair("account_id", GlobalConstans.account_id));
			postParameters.add(new BasicNameValuePair("v", GlobalConstans.vkVersion));
			postParameters.add(new BasicNameValuePair("access_token", accessToken));
			postParameters.add(new BasicNameValuePair("data", json));
			httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
			CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
			InputStream inputStream = closeableHttpResponse.getEntity().getContent();
			String theString = IOUtils.toString(inputStream, "UTF-8");
			System.out.println(theString);
// handle response here...
		} catch (Exception ex) {
			// handle exception here
		} finally {
			httpClient.close();
		}

	}


	public int calculateCpc() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(10) + 10;
	}

	@Override
	public String uploadImg() throws Exception {
		String params = "ad_format=" + 2;
		String accessToken = getAccessToken();
		String query = GlobalConstans.apiUrl + "ads.getUploadURL?" + params + "&access_token=" + accessToken + "&v=" + GlobalConstans.vkVersion;
		System.out.println(query);
		RestTemplate restTemplate = new RestTemplate();
		ImgUploadUrl imgUploadUrl = restTemplate.getForObject(query, ImgUploadUrl.class);
		String resultUrl = imgUploadUrl.getResponse();
		String resultHash = postImg(resultUrl, "test2.jpg");
		return resultHash;
	}

	private String postImg(String uploadUrl, String imagepath) throws Exception {
		HttpClientBuilder builder = HttpClientBuilder.create();
		CloseableHttpClient httpClient = builder.build();

		HttpPost httpPost = new HttpPost(uploadUrl);

		MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
		entityBuilder.addPart("file", new FileBody(new File("D:\\ADHackTM\\" + imagepath)));
// entityBuilder.addPart("fileb", new FileBody(fileb));
		final HttpEntity entity = entityBuilder.build();
		httpPost.setEntity(entity);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
		InputStream inputStream = closeableHttpResponse.getEntity().getContent();
		String result = IOUtils.toString(inputStream, "UTF-8");
		System.out.println(result);
		JSONObject jsonObj = new JSONObject(result);
		String photo = jsonObj.getString("photo");
// print result
		return photo;
	}

}
