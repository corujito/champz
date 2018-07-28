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
import com.corujito.champz.rest.PlayUtils;
import com.corujito.champz.rest.model.Play;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.PlayEntity;

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
public class PlayResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/plays");
        mongoTemplate.dropCollection(PlayEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PlayEntity.class);
    }

    @Test
    public void getPlay() throws Exception {
        PlayEntity entity = PlayUtils.createPlayEntity();
        mongoTemplate.save(entity);

        Play play = template.getForObject(base.toString() + "/" + entity.getId(), Play.class);
        PlayUtils.assertObjects(entity, play);
    }

    @Test
    public void getAllPlay() throws Exception {
        mongoTemplate.save(PlayUtils.createPlayEntity());
        mongoTemplate.save(PlayUtils.createPlayEntity());

        Play[] plays = template.getForObject(base.toString(), Play[].class);
        assertEquals(2, plays.length);
    }

    @Test
    public void testAddPlay() {
        Play c = PlayUtils.createPlay();
        Play play = template.postForObject(base.toString(), c, Play.class);
        assertNotNull(play.getId());
        PlayUtils.assertObjects(c, play);

        PlayEntity entity = mongoTemplate.findById(play.getId(), PlayEntity.class);
        PlayUtils.assertObjects(entity, play);
    }

    @Test
    public void testUpdatePlay() {
        PlayEntity entity = PlayUtils.createPlayEntity();
        entity.setComment("expulso");
        mongoTemplate.save(entity);

        Play newPlay = PlayUtils.createPlay(entity.getId());
        newPlay.setComment("golaço");
        HttpEntity<Play> c = new HttpEntity<>(newPlay);
        ResponseEntity<Play> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Play.class);
        PlayUtils.assertObjects(newPlay, response.getBody());
    }

    @Test
    public void deletePlay() throws Exception {
        PlayEntity entity = PlayUtils.createPlayEntity();
        mongoTemplate.save(entity);

        Play[] plays = template.getForObject(base.toString(), Play[].class);
        assertEquals(1, plays.length);

        template.delete(base.toString() + "/" + entity.getId());

        plays = template.getForObject(base.toString(), Play[].class);
        assertEquals(0, plays.length);
    }
}
