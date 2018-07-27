package com.corujito.champz.rest.repository.entity;

import com.corujito.champz.rest.model.PlayType;

public class PlayEntity extends BaseEntity {

    private String matchId;
    private String playerId;
    private String secondaryPlayerId;
    private int minute;
    private int period;
    private PlayType type;
    private String comment;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getSecondaryPlayerId() {
        return secondaryPlayerId;
    }

    public void setSecondaryPlayerId(String secondaryPlayerId) {
        this.secondaryPlayerId = secondaryPlayerId;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public PlayType getType() {
        return type;
    }

    public void setType(PlayType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
