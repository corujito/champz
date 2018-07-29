package com.corujito.champz.rest.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PlayerMatchAttendance {

    @NotNull(groups = {Existing.class})
    @Null(groups = New.class)
    private String id;
    private boolean startedMatch;
    private String macroPosition;
    private String position;
    private int score;
    private AttendanceType type;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Player player;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Match match;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public PlayerMatchAttendance withId(String id) {
        setId(id);
        return this;
    }

    public PlayerMatchAttendance withPlayer(Player player) {
        setPlayer(player);
        return this;
    }

    public PlayerMatchAttendance withMatch(Match match) {
        setMatch(match);
        return this;
    }

    public PlayerMatchAttendance withTeam(Team team) {
        setTeam(team);
        return this;
    }

    public PlayerMatchAttendance withStartedMatch(boolean startedMatch) {
        setStartedMatch(startedMatch);
        return this;
    }

    public PlayerMatchAttendance withMacroPosition(String macroPosition) {
        setMacroPosition(macroPosition);
        return this;
    }

    public PlayerMatchAttendance withPosition(String position) {
        setPosition(position);
        return this;
    }

    public PlayerMatchAttendance withScore(int score) {
        setScore(score);
        return this;
    }

    public PlayerMatchAttendance withType(AttendanceType type) {
        setType(type);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("player", this.player)
                .append("score", this.score)
                .append("startedMatch", this.startedMatch)
                .append("macroPosition", this.macroPosition)
                .append("match", this.match)
                .append("position", this.position)
                .append("team", this.team)
                .append("type", this.type)
                .toString();
    }
}
