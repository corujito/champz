package com.corujito.champz.rest.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.net.URL;
import java.util.Date;
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
import com.corujito.champz.rest.PlayerTeamPassageUtils;
import com.corujito.champz.rest.model.PlayerTeamPassage;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.PlayerTeamPassageEntity;

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
public class PlayerTeamPassageResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/playerTeamPassages");
        mongoTemplate.dropCollection(PlayerTeamPassageEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PlayerTeamPassageEntity.class);
    }

    @Test
    public void getPassage() throws Exception {
        PlayerTeamPassageEntity entity = PlayerTeamPassageUtils.createPlayerTeamPassageEntity();
        mongoTemplate.save(entity);

        PlayerTeamPassage passage =
                template.getForObject(base.toString() + "/" + entity.getId(), PlayerTeamPassage.class);
        PlayerTeamPassageUtils.assertObjects(entity, passage);
    }

    @Test
    public void getAllPassage() throws Exception {
        mongoTemplate.save(PlayerTeamPassageUtils.createPlayerTeamPassageEntity());
        mongoTemplate.save(PlayerTeamPassageUtils.createPlayerTeamPassageEntity());

        PlayerTeamPassage[] passages = template.getForObject(base.toString(), PlayerTeamPassage[].class);
        assertEquals(2, passages.length);
    }

    @Test
    public void testAddPassage() {
        PlayerTeamPassage c = PlayerTeamPassageUtils.createPlayerTeamPassage();
        PlayerTeamPassage passage = template.postForObject(base.toString(), c, PlayerTeamPassage.class);
        assertNotNull(passage.getId());
        PlayerTeamPassageUtils.assertObjects(c, passage);

        PlayerTeamPassageEntity entity = mongoTemplate.findById(passage.getId(), PlayerTeamPassageEntity.class);
        PlayerTeamPassageUtils.assertObjects(entity, passage);
    }

    @Test
    public void testUpdatePassage() {
        PlayerTeamPassageEntity entity = PlayerTeamPassageUtils.createPlayerTeamPassageEntity();
        entity.setBegin(new Date());
        mongoTemplate.save(entity);

        PlayerTeamPassage newPassage = PlayerTeamPassageUtils.createPlayerTeamPassage(entity.getId())
                .withBegin(new Date()).withEnd(new Date());
        HttpEntity<PlayerTeamPassage> c = new HttpEntity<>(newPassage);
        ResponseEntity<PlayerTeamPassage> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, PlayerTeamPassage.class);
        PlayerTeamPassageUtils.assertObjects(newPassage, response.getBody());
    }

    @Test
    public void deletePassage() throws Exception {
        PlayerTeamPassageEntity entity = PlayerTeamPassageUtils.createPlayerTeamPassageEntity();
        mongoTemplate.save(entity);

        PlayerTeamPassage[] passages = template.getForObject(base.toString(), PlayerTeamPassage[].class);
        assertEquals(1, passages.length);

        template.delete(base.toString() + "/" + entity.getId());

        passages = template.getForObject(base.toString(), PlayerTeamPassage[].class);
        assertEquals(0, passages.length);
    }
}
