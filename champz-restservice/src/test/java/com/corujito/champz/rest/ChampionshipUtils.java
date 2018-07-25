package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

public class ChampionshipUtils {

    public static ChampionshipEntity createChampionshipEntity() {
        ChampionshipEntity entity = new ChampionshipEntity();
        entity.setName("name");
        entity.setDescription("description");
        return entity;
    }

    public static Championship createChampionship(String id) {
        Championship championship = new Championship();
        championship.setId(id);
        championship.setDescription("description");
        championship.setName("name");
        return championship;
    }

    public static void assertObjects(ChampionshipEntity entity, Championship championship) {
        assertThat(championship.getId(), equalTo(entity.getId()));
        assertThat(championship.getName(), equalTo(entity.getName()));
        assertThat(championship.getDescription(), equalTo(entity.getDescription()));
    }

    public static void assertObjects(Championship c1, Championship c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getDescription(), equalTo(c1.getDescription()));
    }
}
