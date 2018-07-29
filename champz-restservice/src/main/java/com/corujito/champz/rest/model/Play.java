package com.corujito.champz.rest.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Play {

    @NotNull(groups = {Existing.class})
    @Null(groups = New.class)
    private String id;
    private int minute;
    private int period;
    private PlayType type;
    private String title;
    @NotNull
    @NotBlank
    private String comment;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Match match;
    private PlayerMatchAttendance player;
    private PlayerMatchAttendance secondaryPlayer;

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
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("minute", this.minute)
                .append("period", this.period)
                .append("comment", this.comment)
                .append("match", this.match)
                .append("player", this.player)
                .append("secondaryPlayer", this.secondaryPlayer)
                .append("title", this.title)
                .append("type", this.type)
                .toString();
    }
}
