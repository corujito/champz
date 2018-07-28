package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.TeamSeasonParticipant;
import com.corujito.champz.rest.repository.entity.TeamSeasonParticipantEntity;

public class TeamSeasonParticipantUtils {

    public static TeamSeasonParticipantEntity createTeamSeasonParticipantEntity() {
        return createTeamSeasonParticipantEntity(null);
    }

    public static TeamSeasonParticipantEntity createTeamSeasonParticipantEntity(String id) {
        return new TeamSeasonParticipantEntity().withId(id).withSeasonId("seasonId").withTeamId("teamId");
    }

    public static TeamSeasonParticipant createTeamSeasonParticipant(String id) {
        return new TeamSeasonParticipant().withId(id).withSeason(SeasonUtils.createSeason("seasonId"))
                .withTeam(TeamUtils.createTeam("teamId"));
    }

    public static void assertObjects(TeamSeasonParticipantEntity entity, TeamSeasonParticipant participant) {
        assertThat(participant.getId(), equalTo(entity.getId()));
        assertThat(participant.getSeason().getId(), equalTo(entity.getSeasonId()));
        assertThat(participant.getTeam().getId(), equalTo(entity.getTeamId()));
    }

    public static void assertObjects(TeamSeasonParticipant c1, TeamSeasonParticipant c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getSeason().getId(), equalTo(c1.getSeason().getId()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
    }
}
