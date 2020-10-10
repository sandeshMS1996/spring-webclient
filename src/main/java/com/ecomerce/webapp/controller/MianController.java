package com.ecomerce.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecomerce.webapp.beans.Quote;

@RestController
public class MianController {

	@GetMapping("/")
	public String fetchData() {
		// define url
		String url = "https://gturnquist-quoters.cfapps.io/api/random";
		// 1. create a rest template
		RestTemplate restTemplate = new RestTemplate();
		
		Quote quote= restTemplate.getForObject(url, Quote.class);
		
		return quote.getValue().getQuote();
	}
}
