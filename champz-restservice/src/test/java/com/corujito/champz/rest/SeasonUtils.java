package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.repository.entity.SeasonEntity;

public class SeasonUtils {

    public static SeasonEntity createSeasonEntity() {
        return createSeasonEntity(null);
    }

    public static SeasonEntity createSeasonEntity(String id) {
        SeasonEntity entity = new SeasonEntity();
        entity.setId(id);
        entity.setTitle("title");
        entity.setRegulation("regulation");
        entity.setChampionshipId("1");
        return entity;
    }

    public static Season createSeason(String id) {
        Season season = new Season();
        season.setId(id);
        season.setTitle("title");
        season.setRegulation("regulation");
        Championship championship = new Championship();
        championship.setId("1");
        season.setChampionship(championship);
        return season;
    }

    public static void assertObjects(SeasonEntity entity, Season season) {
        assertThat(season.getId(), equalTo(entity.getId()));
        assertThat(season.getTitle(), equalTo(entity.getTitle()));
        assertThat(season.getRegulation(), equalTo(entity.getRegulation()));
        assertThat(season.getChampionship().getId(), equalTo(entity.getChampionshipId()));
    }

    public static void assertObjects(Season c1, Season c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getTitle(), equalTo(c1.getTitle()));
        assertThat(c2.getRegulation(), equalTo(c1.getRegulation()));
        assertThat(c2.getChampionship().getId(), equalTo(c1.getChampionship().getId()));
    }
}
