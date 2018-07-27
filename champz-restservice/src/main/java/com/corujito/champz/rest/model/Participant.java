package com.corujito.champz.rest.model;

public class Participant extends BaseDomain {

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

    public Participant withId(String id) {
        setId(id);
        return this;
    }

    public Participant withSeason(Season season) {
        setSeason(season);
        return this;
    }

    public Participant withTeam(Team team) {
        setTeam(team);
        return this;
    }
}
