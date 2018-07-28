package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.model.TeamType;
import com.corujito.champz.rest.repository.entity.TeamEntity;

public class TeamUtils {

    public static TeamEntity createTeamEntity() {
        return new TeamEntity().withName("name").withUserId("1").withJerseyImage("jerseyImage").withNickname("nickname")
                .withPopularName("popularName").withSymbolImage("symbolImage")
                .withType(TeamType.CLUB);
    }

    public static Team createTeam(String id) {
        return new Team().withId(id).withName("name").withUser(UserUtils.createUser("userId"))
                .withJerseyImage("jerseyImage").withNickname("nickname").withPopularName("popularName")
                .withSymbolImage("symbolImage")
                .withType(TeamType.CLUB);
    }

    public static void assertObjects(TeamEntity entity, Team team) {
        assertThat(team.getId(), equalTo(entity.getId()));
        assertThat(team.getName(), equalTo(entity.getName()));
        assertThat(team.getNickname(), equalTo(entity.getNickname()));
        assertThat(team.getPopularName(), equalTo(entity.getPopularName()));
        assertThat(team.getJerseyImage(), equalTo(entity.getJerseyImage()));
        assertThat(team.getSymbolImage(), equalTo(entity.getSymbolImage()));
        assertThat(team.getType(), equalTo(entity.getType()));
        assertThat(team.getTeamLocation(), equalTo(entity.getTeamLocation()));
        assertThat(team.getUser().getId(), equalTo(entity.getUserId()));
    }

    public static void assertObjects(Team c1, Team c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getNickname(), equalTo(c1.getNickname()));
        assertThat(c2.getPopularName(), equalTo(c1.getPopularName()));
        assertThat(c2.getJerseyImage(), equalTo(c1.getJerseyImage()));
        assertThat(c2.getSymbolImage(), equalTo(c1.getSymbolImage()));
        assertThat(c2.getType(), equalTo(c1.getType()));
        assertThat(c2.getTeamLocation(), equalTo(c1.getTeamLocation()));
        assertThat(c2.getUser().getId(), equalTo(c1.getUser().getId()));
    }
}
