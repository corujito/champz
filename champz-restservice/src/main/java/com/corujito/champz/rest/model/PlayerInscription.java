package com.corujito.champz.rest.model;

public class PlayerInscription extends BaseDomain {

    private Season season;
    private Player player;
    private Team team;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PlayerInscription withId(String id) {
        setId(id);
        return this;
    }

    public PlayerInscription withSeason(Season season) {
        setSeason(season);
        return this;
    }

    public PlayerInscription withPlayer(Player player) {
        setPlayer(player);
        return this;
    }

    public PlayerInscription withTeam(Team team) {
        setTeam(team);
        return this;
    }
}
