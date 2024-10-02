package com.demo.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.Service.PostOfficeService;

import lombok.val;

@Service
public class ServiceImpl implements PostOfficeService {
@Autowired
RestTemplate restTemplate;
	//baseURL
String baseurl="https://api.postalpincode.in/";
StringBuilder stringBuilder1=new StringBuilder(baseurl);
StringBuilder stringBuilder2=new StringBuilder(baseurl);
//for  http header
private HttpHeaders gethttpHeaders()
{
	HttpHeaders headers=new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.setContentType(MediaType.APPLICATION_JSON);
	return headers;
}
    //https://api.postalpincode.in/pincode/{pincode}
	@Override
	public List<Map<String, Object>> getbypincode(int pincode) {
		// TODO Auto-generated method stub
		HttpEntity<Void>httpEntity=new HttpEntity<>(gethttpHeaders());
		String url=stringBuilder1.append("pincode").append("/"+pincode).toString();
			val response= restTemplate.exchange(url,HttpMethod.GET, httpEntity,List.class);
		return response.getBody();
	}
	//https://api.postalpincode.in/postoffice/{name}
	@Override
	public List<Map<String, Object>> getbybranchname(String name) {
		// TODO Auto-generated method stub
		HttpEntity<Void>httpEntity=new HttpEntity<>(gethttpHeaders());
		String url1=stringBuilder2.append("postoffice").append("/"+name).toString();
		val response=restTemplate.exchange(url1,HttpMethod.GET, httpEntity,List.class);
		return response.getBody();
	}
}
