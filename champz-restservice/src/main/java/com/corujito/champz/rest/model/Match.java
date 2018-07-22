package com.corujito.champz.rest.model;

import java.util.Date;
import java.util.List;

public class Match {

    private Season season;
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private int homeExtraTimeScore;
    private int awayExtraTimeScore;
    private int homePenaltyScore;
    private int awayPenaltyScore;
    private int round;
    private Date originalDate;
    private Date matchDate;
    private MatchStatus status;
    private Phase phase;
    private List<Attendance> homePlayers;
    private List<Attendance> awayPlayers;
    private List<Play> plays;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getHomeExtraTimeScore() {
        return homeExtraTimeScore;
    }

    public void setHomeExtraTimeScore(int homeExtraTimeScore) {
        this.homeExtraTimeScore = homeExtraTimeScore;
    }

    public int getAwayExtraTimeScore() {
        return awayExtraTimeScore;
    }

    public void setAwayExtraTimeScore(int awayExtraTimeScore) {
        this.awayExtraTimeScore = awayExtraTimeScore;
    }

    public int getHomePenaltyScore() {
        return homePenaltyScore;
    }

    public void setHomePenaltyScore(int homePenaltyScore) {
        this.homePenaltyScore = homePenaltyScore;
    }

    public int getAwayPenaltyScore() {
        return awayPenaltyScore;
    }

    public void setAwayPenaltyScore(int awayPenaltyScore) {
        this.awayPenaltyScore = awayPenaltyScore;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Date getOriginalDate() {
        return originalDate;
    }

    public void setOriginalDate(Date originalDate) {
        this.originalDate = originalDate;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public List<Attendance> getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(List<Attendance> homePlayers) {
        this.homePlayers = homePlayers;
    }

    public List<Attendance> getAwayPlayers() {
        return awayPlayers;
    }

    public void setAwayPlayers(List<Attendance> awayPlayers) {
        this.awayPlayers = awayPlayers;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }
}
