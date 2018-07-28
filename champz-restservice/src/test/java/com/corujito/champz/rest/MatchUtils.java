package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Date;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.MatchStatus;
import com.corujito.champz.rest.repository.entity.MatchEntity;

public class MatchUtils {

    public static MatchEntity createMatchEntity() {
        return new MatchEntity().withAwayExtraTimeScore(1).withAwayPenaltyScore(2).withAwayScore(3).withAwayTeamId("1")
                .withHomeExtraTimeScore(5).withHomePenaltyScore(7).withHomeScore(1)
                .withHomeTeamId("2").withId("1").withMatchDate(new Date()).withOriginalDate(new Date()).withPhaseId("1")
                .withRound(8).withSeasonId("3").withStatus(MatchStatus.FINISHED);
    }

    public static Match createMatch(String id) {
        return new Match().withId(id).withAwayExtraTimeScore(1).withAwayPenaltyScore(2).withAwayScore(3)
                .withAwayTeam(TeamUtils.createTeam("awayTeamId"))
                .withHomeExtraTimeScore(5).withHomePenaltyScore(7).withHomeScore(1)
                .withHomeTeam(TeamUtils.createTeam("homeTeamId"))
                .withMatchDate(new Date()).withOriginalDate(new Date()).withPhase(PhaseUtils.createPhase("phaseId"))
                .withRound(8).withSeason(SeasonUtils.createSeason("seasonId")).withStatus(MatchStatus.FINISHED);
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
