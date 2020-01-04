package com.sapient.footballteam.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.footballteam.model.Team;

@Repository
public class TeamRepository {

	@Value("${host}")
	private String host;

	@Value("${key}")
	private String key;

	public Team getTeamByName(String teamName, Integer leagueId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = host + "?action=get_teams&league_id=" + leagueId + "&APIkey=" + key;
		Team[] teams = restTemplate.getForObject(uri, Team[].class);
		return Arrays.stream(teams).filter(team -> team.getTeamName().equalsIgnoreCase(teamName)).findFirst().get();
	}

}
