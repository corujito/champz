package com.corujito.champz.rest.resource;

import static org.junit.Assert.assertEquals;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.corujito.champz.rest.Application;
import com.corujito.champz.rest.SeasonUtils;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.SeasonEntity;

/*
 * The embedded server is started up on a random port by virtue of the webEnvironment =
 * SpringBootTest.WebEnvironment.RANDOM_PORT and the actual port is discovered at runtime with
 * the @LocalServerPort. MongoConfigIT sets a bean for profile 'test'
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {Application.class, MongoConfigIT.class})
public class SeasonResourceIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void setUp() throws Exception {
        template.withBasicAuth("user", "password");
        template.getRestTemplate().getInterceptors().add(new BasicAuthorizationInterceptor("user", "password"));
        this.base = new URL("http://localhost:" + port + "/api/seasons");
        mongoTemplate.dropCollection(SeasonEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(SeasonEntity.class);
    }

    @Test
    public void getSeason() throws Exception {
        SeasonEntity entity = SeasonUtils.createSeasonEntity();
        mongoTemplate.save(entity);

        Season season = template.getForObject(base.toString() + "/" + entity.getId(), Season.class);
        SeasonUtils.assertObjects(entity, season);
    }

    @Test
    public void getAllSeason() throws Exception {
        mongoTemplate.save(SeasonUtils.createSeasonEntity());
        mongoTemplate.save(SeasonUtils.createSeasonEntity());

        Season[] seasons = template.getForObject(base.toString(), Season[].class);
        assertEquals(2, seasons.length);
    }

    @Test
    public void testAddSeason() {
        Season c = SeasonUtils.createSeason("2");
        Season season = template.postForObject(base.toString(), c, Season.class);
        SeasonUtils.assertObjects(c, season);

        SeasonEntity entity = mongoTemplate.findById(season.getId(), SeasonEntity.class);
        SeasonUtils.assertObjects(entity, season);
    }

    @Test
    public void testUpdateSeason() {
        SeasonEntity entity = SeasonUtils.createSeasonEntity();
        entity.setTitle("campeonato brasileiro 98");
        mongoTemplate.save(entity);

        Season newSeason = SeasonUtils.createSeason(entity.getId());
        newSeason.setTitle("campeonato brasileiro 2018");
        HttpEntity<Season> c = new HttpEntity<>(newSeason);
        ResponseEntity<Season> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Season.class);
        SeasonUtils.assertObjects(newSeason, response.getBody());
    }

    @Test
    public void deleteSeason() throws Exception {
        SeasonEntity entity = SeasonUtils.createSeasonEntity();
        mongoTemplate.save(entity);

        Season[] seasons = template.getForObject(base.toString(), Season[].class);
        assertEquals(1, seasons.length);

        template.delete(base.toString() + "/" + entity.getId());

        seasons = template.getForObject(base.toString(), Season[].class);
        assertEquals(0, seasons.length);
    }
}
