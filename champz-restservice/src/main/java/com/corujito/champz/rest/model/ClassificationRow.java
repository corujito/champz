package com.corujito.champz.rest.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ClassificationRow {

    private int position;
    private int lastPosition;
    private Team team;
    private int points = 0;
    private int numberMatches = 0;
    private int wins = 0;
    private int draws = 0;
    private int losts = 0;
    private int proGoals = 0;
    private int againstGoals = 0;
    private int balanceGoals = 0;
    private int percent = 0;
    private int penaltyPoints = 0;
    private List<Integer> matchesHistory = new ArrayList<>();

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(int lastPosition) {
        this.lastPosition = lastPosition;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumberMatches() {
        return numberMatches;
    }

    public void setNumberMatches(int numberMatches) {
        this.numberMatches = numberMatches;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosts() {
        return losts;
    }

    public void setLosts(int losts) {
        this.losts = losts;
    }

    public int getProGoals() {
        return proGoals;
    }

    public void setProGoals(int proGoals) {
        this.proGoals = proGoals;
    }

    public int getAgainstGoals() {
        return againstGoals;
    }

    public void setAgainstGoals(int againstGoals) {
        this.againstGoals = againstGoals;
    }

    public int getBalanceGoals() {
        return balanceGoals;
    }

    public void setBalanceGoals(int balanceGoals) {
        this.balanceGoals = balanceGoals;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public List<Integer> getMatchesHistory() {
        return matchesHistory;
    }

    public void setMatchesHistory(List<Integer> matchesHistory) {
        this.matchesHistory = matchesHistory;
    }

    public ClassificationRow withPosition(int position) {
        setPosition(position);
        return this;
    }

    public ClassificationRow withLastPosition(int lastPosition) {
        setLastPosition(lastPosition);
        return this;
    }

    public ClassificationRow withTeam(Team team) {
        setTeam(team);
        return this;
    }

    public ClassificationRow withPoints(int points) {
        setPoints(points);
        return this;
    }

    public ClassificationRow withNumberMatches(int numberMatches) {
        setNumberMatches(numberMatches);
        return this;
    }

    public ClassificationRow withWins(int wins) {
        setWins(wins);
        return this;
    }

    public ClassificationRow withDraws(int draws) {
        setDraws(draws);
        return this;
    }

    public ClassificationRow withLosts(int losts) {
        setLosts(losts);
        return this;
    }

    public ClassificationRow withProGoals(int proGoals) {
        setProGoals(proGoals);
        return this;
    }

    public ClassificationRow withAgainstGoals(int againstGoals) {
        setAgainstGoals(againstGoals);
        return this;
    }

    public ClassificationRow withBalanceGoas(int balanceGoals) {
        setBalanceGoals(balanceGoals);
        return this;
    }

    public ClassificationRow withPercent(int percent) {
        setPercent(percent);
        return this;
    }

    public ClassificationRow withPenaltyPoints(int penaltyPoints) {
        setPenaltyPoints(penaltyPoints);
        return this;
    }

    public ClassificationRow withMatchesHistory(List<Integer> matchesHistory) {
        setMatchesHistory(matchesHistory);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("position", this.getPosition())
                .append("team", this.team.getName())
                .append("points", this.getPoints())
                .toString();
    }
}
