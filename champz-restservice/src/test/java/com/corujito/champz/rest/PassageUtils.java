package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Date;
import com.corujito.champz.rest.model.Passage;
import com.corujito.champz.rest.repository.entity.PassageEntity;

public class PassageUtils {

    public static PassageEntity createPassageEntity() {
        return createPassageEntity(null);
    }

    public static PassageEntity createPassageEntity(String id) {
        PassageEntity entity = new PassageEntity();
        entity.setId(id);
        entity.setBegin(new Date());
        entity.setEnd(new Date());
        entity.setPlayerId("playerId");
        entity.setTeamId("teamId");
        return entity;
    }

    public static Passage createPassage(String id) {
        return new Passage().withId(id).withBegin(new Date()).withEnd(new Date())
                .withPlayer(PlayerUtils.createPlayer("playerId")).withTeam(TeamUtils.createTeam("teamId"));
    }

    public static void assertObjects(PassageEntity entity, Passage passage) {
        assertThat(passage.getId(), equalTo(entity.getId()));
        assertThat(passage.getBegin(), equalTo(entity.getBegin()));
        assertThat(passage.getEnd(), equalTo(entity.getEnd()));
        assertThat(passage.getPlayer().getId(), equalTo(entity.getPlayerId()));
        assertThat(passage.getTeam().getId(), equalTo(entity.getTeamId()));
    }

    public static void assertObjects(Passage c1, Passage c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getBegin(), equalTo(c1.getBegin()));
        assertThat(c2.getEnd(), equalTo(c1.getEnd()));
        assertThat(c2.getPlayer().getId(), equalTo(c1.getPlayer().getId()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
    }
}
