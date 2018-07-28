package com.corujito.champz.rest.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class PlayerInscription {

    @NotNull(groups = {Existing.class})
    @Null(groups = New.class)
    private String id;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Season season;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Player player;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Team team;

    public interface Existing {
    }

    public interface New {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
