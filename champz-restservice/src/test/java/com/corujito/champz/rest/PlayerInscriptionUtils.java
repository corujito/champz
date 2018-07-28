package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.PlayerInscription;
import com.corujito.champz.rest.repository.entity.PlayerInscriptionEntity;

public class PlayerInscriptionUtils {

    public static PlayerInscriptionEntity createPlayerInscriptionEntity() {
        return createPlayerInscriptionEntity(null);
    }

    public static PlayerInscriptionEntity createPlayerInscriptionEntity(String id) {
        return new PlayerInscriptionEntity().withId(id).withPlayerId("playerId").withSeasonId("seasonId")
                .withTeamId("teamId");
    }

    public static PlayerInscription createPlayerInscription() {
        return createPlayerInscription(null);
    }

    public static PlayerInscription createPlayerInscription(String id) {
        return new PlayerInscription().withId(id).withPlayer(PlayerUtils.createPlayer("playerId"))
                .withSeason(SeasonUtils.createSeason("seasonId")).withTeam(TeamUtils.createTeam("teamId"));
    }

    public static void assertObjects(PlayerInscriptionEntity entity, PlayerInscription playerInscription) {
        assertThat(playerInscription.getId(), equalTo(entity.getId()));
        assertThat(playerInscription.getTeam().getId(), equalTo(entity.getTeamId()));
        assertThat(playerInscription.getPlayer().getId(), equalTo(entity.getPlayerId()));
        assertThat(playerInscription.getSeason().getId(), equalTo(entity.getSeasonId()));
    }

    public static void assertObjects(PlayerInscription c1, PlayerInscription c2) {
        // assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
        assertThat(c2.getPlayer().getId(), equalTo(c1.getPlayer().getId()));
        assertThat(c2.getSeason().getId(), equalTo(c1.getSeason().getId()));
    }
}
