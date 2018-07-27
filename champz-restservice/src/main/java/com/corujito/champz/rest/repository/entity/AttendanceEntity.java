package com.corujito.champz.rest.repository.entity;

public class AttendanceEntity extends BaseEntity {

    private String playerId;
    private String matchId;
    private String teamId;
    private boolean startedMatch;
    private String macroPosition;
    private String position;
    private int score;

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
}
