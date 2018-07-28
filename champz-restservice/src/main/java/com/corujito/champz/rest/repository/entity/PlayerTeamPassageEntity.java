package com.corujito.champz.rest.repository.entity;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "player_team_passages")
public class PlayerTeamPassageEntity extends BaseEntity {

    private Date begin;
    private Date end;

    private String playerId;
    private String teamId;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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

    public PlayerTeamPassageEntity withId(String id) {
        setId(id);
        return this;
    }

    public PlayerTeamPassageEntity withPlayerId(String playerId) {
        setPlayerId(playerId);
        return this;
    }

    public PlayerTeamPassageEntity withTeamId(String teamId) {
        setTeamId(teamId);
        return this;
    }

    public PlayerTeamPassageEntity withBegin(Date begin) {
        setBegin(begin);
        return this;
    }

    public PlayerTeamPassageEntity withEnd(Date end) {
        setEnd(end);
        return this;
    }
}
