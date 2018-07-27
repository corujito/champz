package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;
import com.corujito.champz.rest.repository.entity.UserEntity;

public class ChampionshipUtils {

    public static ChampionshipEntity createChampionshipEntity() {
        return createChampionshipEntity(null);
    }

    public static ChampionshipEntity createChampionshipEntity(String id) {
        ChampionshipEntity entity = new ChampionshipEntity();
        entity.setId(id);
        entity.setName("name");
        entity.setDescription("description");
        UserEntity user = new UserEntity();
        user.setId("1");
        user.setEmail("email");
        user.setName("name");
        entity.setUserId("1");
        return entity;
    }

    public static Championship createChampionship(String id) {
        Championship championship = new Championship();
        championship.setId(id);
        championship.setDescription("description");
        championship.setName("name");
        User user = new User();
        user.setId("1");
        user.setEmail("email");
        user.setName("name");
        championship.setUser(user);
        return championship;
    }

    public static void assertObjects(ChampionshipEntity entity, Championship championship) {
        assertThat(championship.getId(), equalTo(entity.getId()));
        assertThat(championship.getName(), equalTo(entity.getName()));
        assertThat(championship.getDescription(), equalTo(entity.getDescription()));
        assertThat(championship.getUser().getId(), equalTo(entity.getUserId()));
    }

    public static void assertObjects(Championship c1, Championship c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getDescription(), equalTo(c1.getDescription()));
        assertThat(c2.getUser().getId(), equalTo(c1.getUser().getId()));
    }
}
