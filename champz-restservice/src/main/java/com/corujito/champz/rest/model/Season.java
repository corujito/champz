package com.corujito.champz.rest.model;

import java.util.List;

public class Season extends BaseDomain {

    private String title;
    private String regulation;
    private Championship championship;
    private List<Participant> teams;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public List<Participant> getTeams() {
        return teams;
    }

    public void setTeams(List<Participant> teams) {
        this.teams = teams;
    }

    public Season withId(String id) {
        setId(id);
        return this;
    }

    public Season withTitle(String title) {
        setTitle(title);
        return this;
    }

    public Season withRegulation(String regulation) {
        setRegulation(regulation);
        return this;
    }

    public Season withChampionship(Championship championship) {
        setChampionship(championship);
        return this;
    }

    public Season withTeams(List<Participant> teams) {
        setTeams(teams);
        return this;
    }
}
