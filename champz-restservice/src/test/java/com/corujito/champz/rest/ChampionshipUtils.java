package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

public class ChampionshipUtils {

    public static ChampionshipEntity createChampionshipEntity() {
        return createChampionshipEntity(null);
    }

    public static ChampionshipEntity createChampionshipEntity(String id) {
        return new ChampionshipEntity().withId(id).withName("name").withDescription("description").withUserId("1");
    }

    public static Championship createChampionship() {
        return createChampionship(null);
    }

    public static Championship createChampionship(String id) {
        return new Championship().withId(id).withDescription("description").withName("name")
                .withUser(UserUtils.createUser("userId"));
    }

    public static void assertObjects(ChampionshipEntity entity, Championship championship) {
        assertThat(championship.getId(), equalTo(entity.getId()));
        assertThat(championship.getName(), equalTo(entity.getName()));
        assertThat(championship.getDescription(), equalTo(entity.getDescription()));
        assertThat(championship.getUser().getId(), equalTo(entity.getUserId()));
    }

    public static void assertObjects(Championship c1, Championship c2) {
        // assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getDescription(), equalTo(c1.getDescription()));
        assertThat(c2.getUser().getId(), equalTo(c1.getUser().getId()));
    }
}
