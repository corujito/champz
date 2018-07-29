package com.corujito.champz.rest.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import com.corujito.champz.rest.ChampionshipUtils;
import com.corujito.champz.rest.UserUtils;
import com.corujito.champz.rest.model.Championship;
import com.corujito.champz.rest.model.ChampionshipType;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

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
public class ChampionshipResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/championships");
        mongoTemplate.dropCollection(ChampionshipEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(ChampionshipEntity.class);
    }

    @Test
    public void getChampionship() throws Exception {
        ChampionshipEntity entity = ChampionshipUtils.createChampionshipEntity();
        mongoTemplate.save(entity);

        Championship championship = template.getForObject(base.toString() + "/" + entity.getId(), Championship.class);
        ChampionshipUtils.assertObjects(entity, championship);
    }

    @Test
    public void getAllChampionship() throws Exception {
        mongoTemplate.save(ChampionshipUtils.createChampionshipEntity());
        mongoTemplate.save(ChampionshipUtils.createChampionshipEntity());

        Championship[] championships = template.getForObject(base.toString(), Championship[].class);
        assertEquals(2, championships.length);
    }

    @Test
    public void testAddChampionship() {
        Championship c = ChampionshipUtils.createChampionship();
        Championship championship = template.postForObject(base.toString(), c, Championship.class);
        assertNotNull(championship.getId());
        ChampionshipUtils.assertObjects(c, championship);

        ChampionshipEntity entity = mongoTemplate.findById(championship.getId(), ChampionshipEntity.class);
        ChampionshipUtils.assertObjects(entity, championship);
    }

    @Test
    public void testUpdateChampionship() {
        ChampionshipEntity entity = ChampionshipUtils.createChampionshipEntity();
        entity.setName("campeonato brasileiro");
        mongoTemplate.save(entity);

        Championship newChampionship =
                ChampionshipUtils.createChampionship(entity.getId()).withName("campeonato paulista")
                        .withDescription("desc").withFounded("foun").withImageUrl("imag").withOrganization("org")
                        .withPopularName("pop").withType(ChampionshipType.REGIONAL_TYPE)
                        .withUser(UserUtils.createUser("userId3")).withWebSite("web");
        HttpEntity<Championship> c = new HttpEntity<>(newChampionship);
        ResponseEntity<Championship> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Championship.class);
        ChampionshipUtils.assertObjects(newChampionship, response.getBody());
    }

    @Test
    public void deleteChampionship() throws Exception {
        ChampionshipEntity entity = ChampionshipUtils.createChampionshipEntity();
        mongoTemplate.save(entity);

        Championship[] championships = template.getForObject(base.toString(), Championship[].class);
        assertEquals(1, championships.length);

        template.delete(base.toString() + "/" + entity.getId());

        championships = template.getForObject(base.toString(), Championship[].class);
        assertEquals(0, championships.length);
    }
}
