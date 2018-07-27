package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Participant;
import com.corujito.champz.rest.repository.entity.ParticipantEntity;

public class ParticipantUtils {

    public static ParticipantEntity createParticipantEntity() {
        return createParticipantEntity(null);
    }

    public static ParticipantEntity createParticipantEntity(String id) {
        ParticipantEntity entity = new ParticipantEntity();
        entity.setId(id);
        entity.setSeasonId("seasonId");
        entity.setTeamId("teamId");
        return entity;
    }

    public static Participant createParticipant(String id) {
        return new Participant().withId(id).withSeason(SeasonUtils.createSeason("seasonId"))
                .withTeam(TeamUtils.createTeam("teamId"));
    }

    public static void assertObjects(ParticipantEntity entity, Participant participant) {
        assertThat(participant.getId(), equalTo(entity.getId()));
        assertThat(participant.getSeason().getId(), equalTo(entity.getSeasonId()));
        assertThat(participant.getTeam().getId(), equalTo(entity.getTeamId()));
    }

    public static void assertObjects(Participant c1, Participant c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getSeason().getId(), equalTo(c1.getSeason().getId()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
    }
}
