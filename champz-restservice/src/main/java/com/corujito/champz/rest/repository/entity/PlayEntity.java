package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.PlayType;

@Document(collection = "plays")
public class PlayEntity extends BaseEntity {

    private int minute;
    private int period;
    private PlayType type;
    private String title;
    private String comment;

    private String matchId;
    private String playerId;
    private String secondaryPlayerId;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PlayEntity withId(String id) {
        setId(id);
        return this;
    }

    public PlayEntity withMatchId(String matchId) {
        setMatchId(matchId);
        return this;
    }

    public PlayEntity withPlayerId(String playerId) {
        setPlayerId(playerId);
        return this;
    }

    public PlayEntity withSecondaryPlayerId(String secondaryPlayerId) {
        setSecondaryPlayerId(secondaryPlayerId);
        return this;
    }

    public PlayEntity withMinute(int minute) {
        setMinute(minute);
        return this;
    }

    public PlayEntity withPeriod(int period) {
        setPeriod(period);
        return this;
    }

    public PlayEntity withType(PlayType type) {
        setType(type);
        return this;
    }

    public PlayEntity withComment(String comment) {
        setComment(comment);
        return this;
    }

    public PlayEntity withTitle(String title) {
        setTitle(title);
        return this;
    }
}
