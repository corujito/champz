package com.corujito.champz.rest.model;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Match {

    @NotNull(groups = {Existing.class, PlayerMatchAttendance.New.class, PlayerMatchAttendance.Existing.class,
            Play.New.class, Play.Existing.class})
    @Null(groups = New.class)
    private String id;
    private int homeScore;
    private int awayScore;
    private int homeExtraTimeScore;
    private int awayExtraTimeScore;
    private int homePenaltyScore;
    private int awayPenaltyScore;
    private int round;
    private Date originalDate;
    private Date matchDate;
    private String locale;
    private String title;
    private String subTitle;
    private MatchStatus matchStatus;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Season season;
    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private Phase phase;
    @Valid
    private Group group;
    @Valid
    private Team homeTeam;// participation?
    @Valid
    private Team awayTeam;
    private List<PlayerMatchAttendance> homePlayers;
    private List<PlayerMatchAttendance> awayPlayers;
    private List<Play> plays;

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

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public List<PlayerMatchAttendance> getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(List<PlayerMatchAttendance> homePlayers) {
        this.homePlayers = homePlayers;
    }

    public List<PlayerMatchAttendance> getAwayPlayers() {
        return awayPlayers;
    }

    public void setAwayPlayers(List<PlayerMatchAttendance> awayPlayers) {
        this.awayPlayers = awayPlayers;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Match withId(String id) {
        setId(id);
        return this;
    }

    public Match withLocale(String locale) {
        setLocale(locale);
        return this;
    }

    public Match withTitle(String title) {
        setTitle(title);
        return this;
    }

    public Match withSubTitle(String subTitle) {
        setSubTitle(subTitle);
        return this;
    }

    public Match withSeason(Season season) {
        setSeason(season);
        return this;
    }

    public Match withHomeTeam(Team homeTeam) {
        setHomeTeam(homeTeam);
        return this;
    }

    public Match withAwayTeam(Team awayTeam) {
        setAwayTeam(awayTeam);
        return this;
    }

    public Match withHomeScore(int homeScore) {
        setHomeScore(homeScore);
        return this;
    }

    public Match withAwayScore(int awayScore) {
        setAwayScore(awayScore);
        return this;
    }

    public Match withHomeExtraTimeScore(int homeExtraTimeScore) {
        setHomeExtraTimeScore(homeExtraTimeScore);
        return this;
    }

    public Match withAwayExtraTimeScore(int awayExtraTimeScore) {
        setAwayExtraTimeScore(awayExtraTimeScore);
        return this;
    }

    public Match withHomePenaltyScore(int homePenaltyScore) {
        setHomePenaltyScore(homePenaltyScore);
        return this;
    }

    public Match withAwayPenaltyScore(int awayPenaltyScore) {
        setAwayPenaltyScore(awayPenaltyScore);
        return this;
    }

    public Match withRound(int round) {
        setRound(round);
        return this;
    }

    public Match withOriginalDate(Date originalDate) {
        setOriginalDate(originalDate);
        return this;
    }

    public Match withMatchDate(Date matchDate) {
        setMatchDate(matchDate);
        return this;
    }

    public Match withMatchStatus(MatchStatus matchStatus) {
        setMatchStatus(matchStatus);
        return this;
    }

    public Match withPhase(Phase phase) {
        setPhase(phase);
        return this;
    }

    public Match withGroup(Group group) {
        setGroup(group);
        return this;
    }

    public Match withHomePlayers(List<PlayerMatchAttendance> homePlayers) {
        setHomePlayers(homePlayers);
        return this;
    }

    public Match withAwayPlayers(List<PlayerMatchAttendance> awayPlayers) {
        setAwayPlayers(awayPlayers);
        return this;
    }

    public Match withPlays(List<Play> plays) {
        setPlays(plays);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("awayExtraTimeScore", this.awayExtraTimeScore)
                .append("awayPenaltyScore", this.awayPenaltyScore)
                .append("awayScore", this.awayScore)
                .append("homeExtraTimeScore", this.homeExtraTimeScore)
                .append("homePenaltyScore", this.homePenaltyScore)
                .append("homeScore", this.homeScore)
                .append("round", this.round)
                .append("awayPlayers", this.awayPlayers)
                .append("awayTeam", this.awayTeam)
                .append("group", this.group)
                .append("homePlayers", this.homePlayers)
                .append("homeTeam", this.homeTeam)
                .append("locale", this.locale)
                .append("matchDate", this.matchDate)
                .append("originalDate", this.originalDate)
                .append("phase", this.phase)
                .append("plays", this.plays)
                .append("season", this.season)
                .append("status", this.matchStatus)
                .append("subTitle", this.subTitle)
                .append("title", this.title)
                .toString();
    }
}
