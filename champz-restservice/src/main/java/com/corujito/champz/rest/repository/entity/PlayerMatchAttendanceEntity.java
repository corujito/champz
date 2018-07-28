package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.AttendanceType;

@Document(collection = "player_match_attendances")
public class PlayerMatchAttendanceEntity extends BaseEntity {

    private boolean startedMatch;
    private String macroPosition;
    private String position;
    private int score;
    private AttendanceType type;

    private String playerId;
    private String matchId;
    private String teamId;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public boolean isStartedMatch() {
        return startedMatch;
    }

    public void setStartedMatch(boolean startedMatch) {
        this.startedMatch = startedMatch;
    }

    public String getMacroPosition() {
        return macroPosition;
    }

    public void setMacroPosition(String macroPosition) {
        this.macroPosition = macroPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public AttendanceType getType() {
        return type;
    }

    public void setType(AttendanceType type) {
        this.type = type;
    }

    public PlayerMatchAttendanceEntity withId(String id) {
        setId(id);
        return this;
    }

    public PlayerMatchAttendanceEntity withPlayerId(String playerId) {
        setPlayerId(playerId);
        return this;
    }

    public PlayerMatchAttendanceEntity withMatchId(String matchId) {
        setMatchId(matchId);
        return this;
    }

    public PlayerMatchAttendanceEntity withTeamId(String teamId) {
        setTeamId(teamId);
        return this;
    }

    public PlayerMatchAttendanceEntity withStartedMatch(boolean startedMatch) {
        setStartedMatch(startedMatch);
        return this;
    }

    public PlayerMatchAttendanceEntity withMacroPosition(String macroPosition) {
        setMacroPosition(macroPosition);
        return this;
    }

    public PlayerMatchAttendanceEntity withPosition(String position) {
        setPosition(position);
        return this;
    }

    public PlayerMatchAttendanceEntity withScore(int score) {
        setScore(score);
        return this;
    }

    public PlayerMatchAttendanceEntity withType(AttendanceType type) {
        setType(type);
        return this;
    }
}
