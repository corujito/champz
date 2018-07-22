package com.corujito.champz.rest.model;

public class Play extends BaseDomain {

    private Match match;
    private Attendance player;
    private Attendance secondaryPlayer;
    private int minute;
    private int period;
    private PlayType type;
    private String comment;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Attendance getPlayer() {
        return player;
    }

    public void setPlayer(Attendance player) {
        this.player = player;
    }

    public Attendance getSecondaryPlayer() {
        return secondaryPlayer;
    }

    public void setSecondaryPlayer(Attendance secondaryPlayer) {
        this.secondaryPlayer = secondaryPlayer;
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
