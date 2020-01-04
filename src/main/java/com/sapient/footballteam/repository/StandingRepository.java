package com.sapient.footballteam.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.footballteam.model.Standing;

@Repository
public class StandingRepository {

	@Value("${host}")
	private String host;

	@Value("${key}")
	private String key;

	public Standing getStanding(Integer leagueId, Integer teamId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = host + "?action=get_standings&league_id=" + leagueId + "&APIkey=" + key;
		Standing[] standings = restTemplate.getForObject(uri, Standing[].class);
		return Arrays.stream(standings).filter(standing -> standing.getTeamId().equals(teamId)).findFirst().get();
	}

}
