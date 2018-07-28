package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.GroupTeamPresence;
import com.corujito.champz.rest.repository.entity.GroupTeamPresenceEntity;

public class GroupTeamPresenceUtils {

    public static GroupTeamPresenceEntity createGroupTeamPresenceEntity() {
        return createGroupTeamPresenceEntity(null);
    }

    public static GroupTeamPresenceEntity createGroupTeamPresenceEntity(String id) {
        return new GroupTeamPresenceEntity().withId(id).withInitialPoints(0).withGroupId("groupId")
                .withTeamId("teamId");
    }

    public static GroupTeamPresence createGroupTeamPresence(String id) {
        return new GroupTeamPresence().withId(id).withInitialPoints(0).withGroup(GroupUtils.createGroup("groupId"))
                .withTeam(TeamUtils.createTeam("teamId"));
    }

    public static void assertObjects(GroupTeamPresenceEntity entity, GroupTeamPresence groupTeamPresence) {
        assertThat(groupTeamPresence.getId(), equalTo(entity.getId()));
        assertThat(groupTeamPresence.getInitialPoints(), equalTo(entity.getInitialPoints()));
        assertThat(groupTeamPresence.getGroup().getId(), equalTo(entity.getGroupId()));
        assertThat(groupTeamPresence.getTeam().getId(), equalTo(entity.getTeamId()));
    }

    public static void assertObjects(GroupTeamPresence c1, GroupTeamPresence c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getInitialPoints(), equalTo(c1.getInitialPoints()));
        assertThat(c2.getGroup().getId(), equalTo(c1.getGroup().getId()));
        assertThat(c2.getTeam().getId(), equalTo(c1.getTeam().getId()));
    }
}
