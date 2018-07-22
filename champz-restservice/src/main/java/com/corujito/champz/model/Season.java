package com.corujito.champz.model;

import java.util.List;

public class Season {

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
}
