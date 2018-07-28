package com.corujito.champz.rest.model;

import java.util.List;

public class Season extends BaseDomain {

    private String title;
    private String regulation;
    private Championship championship;
    private List<TeamSeasonParticipant> teams;
    private List<PlayerInscription> playerInscriptions;
    private List<Phase> phases;

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

    public List<TeamSeasonParticipant> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamSeasonParticipant> teams) {
        this.teams = teams;
    }

    public List<PlayerInscription> getPlayerInscriptions() {
        return playerInscriptions;
    }

    public void setPlayerInscriptions(List<PlayerInscription> playerInscriptions) {
        this.playerInscriptions = playerInscriptions;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public Season withId(String id) {
        setId(id);
        return this;
    }

    public Season withPhases(List<Phase> phases) {
        setPhases(phases);
        return this;
    }

    public Season withPlayerInscriptions(List<PlayerInscription> playerInscriptions) {
        setPlayerInscriptions(playerInscriptions);
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

    public Season withTeams(List<TeamSeasonParticipant> teams) {
        setTeams(teams);
        return this;
    }
}
