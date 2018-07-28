package com.corujito.champz.rest.model;

import java.util.Date;

public class PlayerTeamPassage extends BaseDomain {

    private Date begin;
    private Date end;

    private Player player;
    private Team team;

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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public PlayerTeamPassage withId(String id) {
        setId(id);
        return this;
    }

    public PlayerTeamPassage withPlayer(Player player) {
        setPlayer(player);
        return this;
    }

    public PlayerTeamPassage withTeam(Team team) {
        setTeam(team);
        return this;
    }

    public PlayerTeamPassage withBegin(Date begin) {
        setBegin(begin);
        return this;
    }

    public PlayerTeamPassage withEnd(Date end) {
        setEnd(end);
        return this;
    }
}
