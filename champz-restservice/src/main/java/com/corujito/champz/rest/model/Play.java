package com.corujito.champz.rest.model;

public class Play extends BaseDomain {

    private int minute;
    private int period;
    private PlayType type;
    private String title;
    private String comment;

    private Match match;
    private PlayerMatchAttendance player;
    private PlayerMatchAttendance secondaryPlayer;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public PlayerMatchAttendance getPlayer() {
        return player;
    }

    public void setPlayer(PlayerMatchAttendance player) {
        this.player = player;
    }

    public PlayerMatchAttendance getSecondaryPlayer() {
        return secondaryPlayer;
    }

    public void setSecondaryPlayer(PlayerMatchAttendance secondaryPlayer) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Play withId(String id) {
        setId(id);
        return this;
    }

    public Play withMatch(Match match) {
        setMatch(match);
        return this;
    }

    public Play withPlayer(PlayerMatchAttendance player) {
        setPlayer(player);
        return this;
    }

    public Play withSecondaryPlayer(PlayerMatchAttendance secondaryPlayer) {
        setSecondaryPlayer(secondaryPlayer);
        return this;
    }

    public Play withMinute(int minute) {
        setMinute(minute);
        return this;
    }

    public Play withPeriod(int period) {
        setPeriod(period);
        return this;
    }

    public Play withType(PlayType type) {
        setType(type);
        return this;
    }

    public Play withComment(String comment) {
        setComment(comment);
        return this;
    }

    public Play withTitle(String title) {
        setTitle(title);
        return this;
    }
}
