package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.model.GroupTeamPresence;
import com.corujito.champz.rest.repository.entity.GroupEntity;
import com.corujito.champz.rest.repository.entity.GroupTeamPresenceEntity;

public class GroupUtils {

    public static GroupEntity createGroupEntity() {
        return createGroupEntity(null);
    }

    public static GroupEntity createGroupEntity(String id) {
        List<GroupTeamPresenceEntity> presences =
                Arrays.asList(GroupTeamPresenceUtils.createGroupTeamPresenceEntity("team1"));
        return new GroupEntity().withId(id).withName("name").withOrder(1).withPhaseId("phaseId")
                .withPresences(presences);
    }

    public static Group createGroup() {
        return createGroup(null);
    }

    public static Group createGroup(String id) {
        List<GroupTeamPresence> presences = Arrays.asList(GroupTeamPresenceUtils.createGroupTeamPresence("team1"));
        return new Group().withId(id).withName("name").withOrder(1).withPhase(PhaseUtils.createPhase("phaseId"))
                .withPresences(presences);
    }

    public static void assertObjects(GroupEntity entity, Group group) {
        assertThat(group.getId(), equalTo(entity.getId()));
        assertThat(group.getName(), equalTo(entity.getName()));
        assertThat(group.getOrder(), equalTo(entity.getOrder()));
        assertThat(group.getPhase().getId(), equalTo(entity.getPhaseId()));
    }

    public static void assertObjects(Group c1, Group c2) {
        // assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getOrder(), equalTo(c1.getOrder()));
        assertThat(c2.getPhase().getId(), equalTo(c1.getPhase().getId()));
        assertThat(c2.getPresences().size(), equalTo(c1.getPresences().size()));
    }
}
