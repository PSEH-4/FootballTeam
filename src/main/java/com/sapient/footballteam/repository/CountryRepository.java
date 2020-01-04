package com.sapient.footballteam.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.footballteam.model.Country;

@Repository
public class CountryRepository {

	@Value("${host}")
	private String host;

	@Value("${key}")
	private String key;

	public Country getCountryByName(String name) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = host + "?action=get_countries&APIkey=" + key;
		Country[] countryList = restTemplate.getForObject(uri, Country[].class);
		return Arrays.stream(countryList).filter(coutnry -> coutnry.getName().equalsIgnoreCase(name)).findFirst().get();
	}
}
