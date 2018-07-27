package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.repository.entity.PhaseEntity;

public class PhaseUtils {

    public static PhaseEntity createPhaseEntity() {
        return createPhaseEntity(null);
    }

    public static PhaseEntity createPhaseEntity(String id) {
        PhaseEntity entity = new PhaseEntity();
        entity.setId(id);
        return entity;
    }

    public static Phase createPhase(String id) {
        return new Phase().withId(id).withCurrentRound(1).withDownZone(2).withMain(true).withName("name")
                .withRepetitions(3).withSeason(SeasonUtils.createSeason("seasonId")).withUpZone(9);
    }

    public static void assertObjects(PhaseEntity entity, Phase phase) {
        assertThat(phase.getId(), equalTo(entity.getId()));
        assertThat(phase.getCurrentRound(), equalTo(entity.getCurrentRound()));
        assertThat(phase.getDownZone(), equalTo(entity.getDownZone()));
        assertThat(phase.getName(), equalTo(entity.getName()));
        assertThat(phase.getRepetitions(), equalTo(entity.getRepetitions()));
        assertThat(phase.getSeason().getId(), equalTo(entity.getSeasonId()));
        assertThat(phase.getUpZone(), equalTo(entity.getUpZone()));
    }

    public static void assertObjects(Phase c1, Phase c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getCurrentRound(), equalTo(c1.getCurrentRound()));
        assertThat(c2.getDownZone(), equalTo(c1.getDownZone()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getRepetitions(), equalTo(c1.getRepetitions()));
        assertThat(c2.getSeason().getId(), equalTo(c1.getSeason().getId()));
        assertThat(c2.getUpZone(), equalTo(c1.getUpZone()));
    }
}
