package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Date;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.MatchStatus;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.repository.entity.MatchEntity;

public class MatchUtils {

    public static MatchEntity createMatchEntity() {
        MatchEntity entity = new MatchEntity();
        entity.setAwayExtraTimeScore(1);
        entity.setAwayPenaltyScore(2);
        entity.setAwayScore(3);
        entity.setAwayTeamId("1");
        entity.setHomeExtraTimeScore(5);
        entity.setHomePenaltyScore(7);
        entity.setHomeScore(1);
        entity.setHomeTeamId("2");
        entity.setId("1");
        entity.setMatchDate(new Date());
        entity.setOriginalDate(new Date());
        entity.setPhaseId("1");
        entity.setRound(8);
        entity.setSeasonId("3");
        entity.setStatus(MatchStatus.CANCELED);
        return entity;
    }

    public static Match createMatch(String id) {
        Match match = new Match();
        match.setId(id);
        match.setAwayExtraTimeScore(1);
        match.setAwayPenaltyScore(2);
        match.setAwayScore(3);
        Team awayTeam = new Team();
        awayTeam.setId("1");
        match.setAwayTeam(awayTeam);
        match.setHomeExtraTimeScore(5);
        match.setHomePenaltyScore(7);
        match.setHomeScore(1);
        Team homeTeam = new Team();
        homeTeam.setId("3");
        match.setHomeTeam(homeTeam);
        match.setMatchDate(new Date());
        match.setOriginalDate(new Date());
        Phase phase = new Phase();
        phase.setId("4");
        match.setPhase(phase);
        match.setRound(8);
        Season season = new Season();
        season.setId("7");
        match.setSeason(season);
        match.setStatus(MatchStatus.CANCELED);
        return match;
    }

    public static void assertObjects(MatchEntity entity, Match match) {
        assertThat(match.getId(), equalTo(entity.getId()));
        assertThat(match.getAwayExtraTimeScore(), equalTo(entity.getAwayExtraTimeScore()));
        assertThat(match.getAwayPenaltyScore(), equalTo(entity.getAwayPenaltyScore()));
        assertThat(match.getAwayScore(), equalTo(entity.getAwayScore()));
        assertThat(match.getAwayTeam().getId(), equalTo(entity.getAwayTeamId()));
        assertThat(match.getHomeExtraTimeScore(), equalTo(entity.getHomeExtraTimeScore()));
        assertThat(match.getHomePenaltyScore(), equalTo(entity.getHomePenaltyScore()));
        assertThat(match.getHomeScore(), equalTo(entity.getHomeScore()));
        assertThat(match.getHomeTeam().getId(), equalTo(entity.getHomeTeamId()));
        assertThat(match.getMatchDate(), equalTo(entity.getMatchDate()));
        assertThat(match.getOriginalDate(), equalTo(entity.getOriginalDate()));
        assertThat(match.getPhase().getId(), equalTo(entity.getPhaseId()));
        assertThat(match.getSeason().getId(), equalTo(entity.getSeasonId()));
        assertThat(match.getStatus(), equalTo(entity.getStatus()));
    }

    public static void assertObjects(Match c1, Match c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getAwayExtraTimeScore(), equalTo(c1.getAwayExtraTimeScore()));
        assertThat(c2.getAwayPenaltyScore(), equalTo(c1.getAwayPenaltyScore()));
        assertThat(c2.getAwayScore(), equalTo(c1.getAwayScore()));
        assertThat(c2.getAwayTeam().getId(), equalTo(c1.getAwayTeam().getId()));
        assertThat(c2.getHomeExtraTimeScore(), equalTo(c1.getHomeExtraTimeScore()));
        assertThat(c2.getHomePenaltyScore(), equalTo(c1.getHomePenaltyScore()));
        assertThat(c2.getHomeScore(), equalTo(c1.getHomeScore()));
        assertThat(c2.getHomeTeam().getId(), equalTo(c1.getHomeTeam().getId()));
        assertThat(c2.getMatchDate(), equalTo(c1.getMatchDate()));
        assertThat(c2.getOriginalDate(), equalTo(c1.getOriginalDate()));
        assertThat(c2.getPhase().getId(), equalTo(c1.getPhase().getId()));
        assertThat(c2.getSeason().getId(), equalTo(c1.getSeason().getId()));
        assertThat(c2.getStatus(), equalTo(c1.getStatus()));
    }
}
