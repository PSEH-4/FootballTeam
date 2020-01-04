package com.sapient.footballteam.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

	@JsonProperty("team_key")
	private Integer teamId;

	@JsonProperty("team_name")
	private String teamName;

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [teamId=").append(teamId).append(", teamName=").append(teamName).append("]");
		return builder.toString();
	}

}
