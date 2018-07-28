package com.corujito.champz.rest.model;

public class TeamSeasonParticipant extends BaseDomain {

    private Season season;
    private Team team;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TeamSeasonParticipant withId(String id) {
        setId(id);
        return this;
    }

    public TeamSeasonParticipant withSeason(Season season) {
        setSeason(season);
        return this;
    }

    public TeamSeasonParticipant withTeam(Team team) {
        setTeam(team);
        return this;
    }
}
