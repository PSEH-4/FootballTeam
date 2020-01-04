package com.sapient.footballteam;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.footballteam.model.Country;
import com.sapient.footballteam.model.League;
import com.sapient.footballteam.repository.CountryRepository;
import com.sapient.footballteam.repository.LeagueRepository;
import com.sapient.footballteam.repository.StandingRepository;
import com.sapient.footballteam.repository.TeamRepository;

@SpringBootTest
class FootballTeamApplicationTests {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCountryRepositoryTest() {
		Country country = countryRepository.getCountryByName("France");
		assertTrue(46 == country.getId());
	}

	@Test
	public void testLeagueRepositoryTest() {
		League league = leagueRepository.getLeagueByName("Championship", 41);
		assertTrue(149 == league.getId());
	}

	@Test
	public void testTeamRepo() {
		assertTrue(2611 == teamRepository.getTeamByName("Leicester", 148).getTeamId());
	}

}
