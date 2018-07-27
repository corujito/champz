package com.corujito.champz.rest.model;

public class Attendance extends BaseDomain {

    private Player player;
    private Match match;
    private Team team;
    private boolean startedMatch;
    private String macroPosition;
    private String position;
    private int score;

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

    public Attendance withId(String id) {
        setId(id);
        return this;
    }

    public Attendance withPlayer(Player player) {
        setPlayer(player);
        return this;
    }

    public Attendance withMatch(Match match) {
        setMatch(match);
        return this;
    }

    public Attendance withTeam(Team team) {
        setTeam(team);
        return this;
    }

    public Attendance withStartedMatch(boolean startedMatch) {
        setStartedMatch(startedMatch);
        return this;
    }

    public Attendance withMacroPosition(String macroPosition) {
        setMacroPosition(macroPosition);
        return this;
    }

    public Attendance withPosition(String position) {
        setPosition(position);
        return this;
    }

    public Attendance withScore(int score) {
        setScore(score);
        return this;
    }
}
