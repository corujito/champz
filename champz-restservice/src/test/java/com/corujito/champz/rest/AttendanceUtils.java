package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Attendance;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.repository.entity.AttendanceEntity;

public class AttendanceUtils {

    public static AttendanceEntity createAttendanceEntity() {
        return createAttendanceEntity(null);
    }

    public static AttendanceEntity createAttendanceEntity(String id) {
        AttendanceEntity entity = new AttendanceEntity();
        entity.setId(id);
        entity.setMacroPosition("macroPosition");
        entity.setMatchId("1");
        entity.setPlayerId("3");
        entity.setPosition("position");
        entity.setScore(3);
        entity.setStartedMatch(true);
        entity.setTeamId("teamId");
        return entity;
    }

    public static Attendance createAttendance(String id) {
        Attendance attendance = new Attendance();
        attendance.setId(id);
        attendance.setMacroPosition("macroPosition");
        Match match = new Match();
        match.setId("match");
        attendance.setMatch(match);
        Player player = new Player();
        player.setId("playerId");
        attendance.setPlayer(player);
        attendance.setPosition("position");
        attendance.setScore(3);
        attendance.setStartedMatch(true);
        Team team = new Team();
        team.setId("teamId");
        attendance.setTeam(team);
        return attendance;
    }

    public static void assertObjects(AttendanceEntity entity, Attendance attendance) {
        assertThat(attendance.getId(), equalTo(entity.getId()));
        assertThat(attendance.getMacroPosition(), equalTo(entity.getMacroPosition()));
        assertThat(attendance.getMatch().getId(), equalTo(entity.getMatchId()));
        assertThat(attendance.getPlayer().getId(), equalTo(entity.getPlayerId()));
        assertThat(attendance.getPosition(), equalTo(entity.getPosition()));
        assertThat(attendance.getScore(), equalTo(entity.getScore()));
        assertThat(attendance.getTeam().getId(), equalTo(entity.getTeamId()));
    }

    public static void assertObjects(Attendance c1, Attendance c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getMacroPosition(), equalTo(c1.getMacroPosition()));
        assertThat(c2.getMatch().getId(), equalTo(c1.getMatch().getId()));
        assertThat(c2.getPlayer().getId(), equalTo(c1.getPlayer().getId()));
        assertThat(c2.getPosition(), equalTo(c1.getPosition()));
        assertThat(c2.getScore(), equalTo(c1.getScore()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
    }
}
