package com.corujito.champz.rest.model;

import java.util.Map;

public class SeasonSummary {

    private Season season;
    private Map<String, Team> teams;
    private Map<String, Player> players;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Map<String, Team> getTeams() {
        return teams;
    }

    public void setTeams(Map<String, Team> teams) {
        this.teams = teams;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }

    public SeasonSummary withSeason(Season season) {
        setSeason(season);
        return this;
    }

    public SeasonSummary withTeams(Map<String, Team> teams) {
        setTeams(teams);
        return this;
    }

    public SeasonSummary withPlayers(Map<String, Player> players) {
        setPlayers(players);
        return this;
    }
}
