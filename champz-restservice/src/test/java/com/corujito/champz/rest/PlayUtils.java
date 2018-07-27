package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Attendance;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.Play;
import com.corujito.champz.rest.model.PlayType;
import com.corujito.champz.rest.repository.entity.PlayEntity;

public class PlayUtils {

    public static PlayEntity createPlayEntity() {
        return createPlayEntity(null);
    }

    public static PlayEntity createPlayEntity(String id) {
        PlayEntity entity = new PlayEntity();
        entity.setId(id);
        entity.setComment("comment");
        entity.setMatchId("matchId");
        entity.setMinute(12);
        entity.setPeriod(2);
        entity.setPlayerId("playerId");
        entity.setSecondaryPlayerId("secondaryPlayerId");
        entity.setType(PlayType.GOAL);
        return entity;
    }

    public static Play createPlay(String id) {
        Play play = new Play();
        play.setId(id);
        play.setComment("comment");
        Match match = new Match();
        match.setId("matchId");
        play.setMatch(match);
        play.setMinute(12);
        play.setPeriod(2);
        Attendance player = new Attendance();
        player.setId("playerId");
        play.setPlayer(player);
        Attendance player2 = new Attendance();
        player2.setId("secondaryPlayerId");
        play.setSecondaryPlayer(player2);
        play.setType(PlayType.GOAL);
        return play;
    }

    public static void assertObjects(PlayEntity entity, Play play) {
        assertThat(play.getId(), equalTo(entity.getId()));
        assertThat(play.getComment(), equalTo(entity.getComment()));
        assertThat(play.getMatch().getId(), equalTo(entity.getMatchId()));
        assertThat(play.getMinute(), equalTo(entity.getMinute()));
        assertThat(play.getPeriod(), equalTo(entity.getPeriod()));
        assertThat(play.getPlayer().getId(), equalTo(entity.getPlayerId()));
        assertThat(play.getSecondaryPlayer().getId(), equalTo(entity.getSecondaryPlayerId()));
        assertThat(play.getType(), equalTo(entity.getType()));
    }

    public static void assertObjects(Play c1, Play c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getComment(), equalTo(c1.getComment()));
        assertThat(c2.getMatch().getId(), equalTo(c1.getMatch().getId()));
        assertThat(c2.getMinute(), equalTo(c1.getMinute()));
        assertThat(c2.getPeriod(), equalTo(c1.getPeriod()));
        assertThat(c2.getPlayer().getId(), equalTo(c1.getPlayer().getId()));
        assertThat(c2.getSecondaryPlayer().getId(), equalTo(c1.getSecondaryPlayer().getId()));
        assertThat(c2.getType(), equalTo(c1.getType()));
    }
}
