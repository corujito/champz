package com.corujito.champz.rest.repository.entity;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.MatchStatus;

@Document(collection = "matches")
public class MatchEntity extends BaseEntity {

    private String seasonId;
    private String homeTeamId;
    private String awayTeamId;
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
    private String phaseId;

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
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

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }
}
