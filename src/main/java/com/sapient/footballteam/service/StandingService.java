package com.sapient.footballteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.footballteam.model.Country;
import com.sapient.footballteam.model.League;
import com.sapient.footballteam.model.Standing;
import com.sapient.footballteam.model.Team;
import com.sapient.footballteam.repository.CountryRepository;
import com.sapient.footballteam.repository.LeagueRepository;
import com.sapient.footballteam.repository.StandingRepository;
import com.sapient.footballteam.repository.TeamRepository;

@Service
public class StandingService {

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private LeagueRepository leagueRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private StandingRepository standingRepository;

	public Standing getStanding(String countryName, String leagueName, String teamName) {
		Integer teamId = teamRepository.getTeamByName(teamName, 148).getTeamId();
		return standingRepository.getStanding(148, teamId);
	}

	public Country getCountry(String countryName) {
		return countryRepository.getCountryByName(countryName);
	}

	public Team getTeam(String teamName, Integer leagueId) {
		return teamRepository.getTeamByName(teamName, leagueId);
	}

	public League getLeague(String name, Integer countryId) {
		return leagueRepository.getLeagueByName(name, countryId);
	}
}
