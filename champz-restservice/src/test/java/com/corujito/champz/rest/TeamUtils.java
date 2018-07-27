package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.repository.entity.TeamEntity;
import com.corujito.champz.rest.repository.entity.UserEntity;

public class TeamUtils {

    public static TeamEntity createTeamEntity() {
        TeamEntity entity = new TeamEntity();
        entity.setName("name");
        UserEntity user = new UserEntity();
        user.setId("1");
        user.setEmail("email");
        entity.setUserId("1");
        return entity;
    }

    public static Team createTeam(String id) {
        return new Team().withId(id).withName("name").withUser(new User().withId("userId").withEmail("email"));
    }

    public static void assertObjects(TeamEntity entity, Team team) {
        assertThat(team.getId(), equalTo(entity.getId()));
        assertThat(team.getName(), equalTo(entity.getName()));
        assertThat(team.getUser().getId(), equalTo(entity.getUserId()));
    }

    public static void assertObjects(Team c1, Team c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getUser().getId(), equalTo(c1.getUser().getId()));
    }
}
