package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Date;
import com.corujito.champz.rest.model.PlayerTeamPassage;
import com.corujito.champz.rest.repository.entity.PlayerTeamPassageEntity;

public class PlayerTeamPassageUtils {

    public static PlayerTeamPassageEntity createPlayerTeamPassageEntity() {
        return createPlayerTeamPassageEntity(null);
    }

    public static PlayerTeamPassageEntity createPlayerTeamPassageEntity(String id) {
        return new PlayerTeamPassageEntity().withId(id).withBegin(new Date()).withEnd(new Date())
                .withPlayerId("playerId").withTeamId("teamId");
    }

    public static PlayerTeamPassage createPlayerTeamPassage() {
        return createPlayerTeamPassage(null);
    }

    public static PlayerTeamPassage createPlayerTeamPassage(String id) {
        return new PlayerTeamPassage().withId(id).withBegin(new Date()).withEnd(new Date())
                .withTeam(TeamUtils.createTeam("teamId")).withPlayer(PlayerUtils.createPlayer("playerId"));
    }

    public static void assertObjects(PlayerTeamPassageEntity entity, PlayerTeamPassage playerTeamPassage) {
        assertThat(playerTeamPassage.getId(), equalTo(entity.getId()));
        assertThat(playerTeamPassage.getBegin(), equalTo(entity.getBegin()));
        assertThat(playerTeamPassage.getEnd(), equalTo(entity.getEnd()));
        assertThat(playerTeamPassage.getPlayer().getId(), equalTo(entity.getPlayerId()));
        assertThat(playerTeamPassage.getTeam().getId(), equalTo(entity.getTeamId()));
    }

    public static void assertObjects(PlayerTeamPassage c1, PlayerTeamPassage c2) {
        // assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getBegin(), equalTo(c1.getBegin()));
        assertThat(c2.getEnd(), equalTo(c1.getEnd()));
        assertThat(c2.getPlayer().getId(), equalTo(c1.getPlayer().getId()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
    }
}
