package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.PlayerMatchAttendance;
import com.corujito.champz.rest.repository.entity.PlayerMatchAttendanceEntity;

public class AttendanceUtils {

    public static PlayerMatchAttendanceEntity createAttendanceEntity() {
        return createAttendanceEntity(null);
    }

    public static PlayerMatchAttendanceEntity createAttendanceEntity(String id) {
        return new PlayerMatchAttendanceEntity().withId(id).withMacroPosition("macroPosition").withMatchId("1")
                .withPlayerId("3").withPosition("position").withScore(3).withStartedMatch(true).withTeamId("teamId");
    }

    public static PlayerMatchAttendance createAttendance() {
        return createAttendance(null);
    }

    public static PlayerMatchAttendance createAttendance(String id) {
        return new PlayerMatchAttendance().withId(id).withMacroPosition("macroPosition")
                .withMatch(MatchUtils.createMatch("matchId")).withPlayer(PlayerUtils.createPlayer("playerId"))
                .withPosition("position").withScore(3).withStartedMatch(true).withTeam(TeamUtils.createTeam("teamId"));
    }

    public static void assertObjects(PlayerMatchAttendanceEntity entity, PlayerMatchAttendance attendance) {
        assertThat(attendance.getId(), equalTo(entity.getId()));
        assertThat(attendance.getMacroPosition(), equalTo(entity.getMacroPosition()));
        assertThat(attendance.getMatch().getId(), equalTo(entity.getMatchId()));
        assertThat(attendance.getPlayer().getId(), equalTo(entity.getPlayerId()));
        assertThat(attendance.getPosition(), equalTo(entity.getPosition()));
        assertThat(attendance.getScore(), equalTo(entity.getScore()));
        assertThat(attendance.getTeam().getId(), equalTo(entity.getTeamId()));
    }

    public static void assertObjects(PlayerMatchAttendance c1, PlayerMatchAttendance c2) {
        // assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getMacroPosition(), equalTo(c1.getMacroPosition()));
        assertThat(c2.getMatch().getId(), equalTo(c1.getMatch().getId()));
        assertThat(c2.getPlayer().getId(), equalTo(c1.getPlayer().getId()));
        assertThat(c2.getPosition(), equalTo(c1.getPosition()));
        assertThat(c2.getScore(), equalTo(c1.getScore()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
    }
}
