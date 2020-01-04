package com.sapient.footballteam.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.footballteam.model.League;

@Repository
public class LeagueRepository {
	@Value("${host}")
	private String host;

	@Value("${key}")
	private String key;

	public League getLeagueByName(String name, Integer countryId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = host + "?action=get_leagues&country_id=" + countryId + "&APIkey=" + key;
		League[] leagueList = restTemplate.getForObject(uri, League[].class);
		return Arrays.stream(leagueList).filter(coutnry -> coutnry.getName().equalsIgnoreCase(name)).findFirst().get();
	}

}