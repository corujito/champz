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
import com.corujito.champz.rest.PlayerInscriptionUtils;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.model.PlayerInscription;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.PlayerInscriptionEntity;

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
public class PlayerInscriptionResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/playerInscriptions");
        mongoTemplate.dropCollection(PlayerInscriptionEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PlayerInscriptionEntity.class);
    }

    @Test
    public void getPlayerInscription() throws Exception {
        PlayerInscriptionEntity entity = PlayerInscriptionUtils.createPlayerInscriptionEntity();
        mongoTemplate.save(entity);

        PlayerInscription playerInscription =
                template.getForObject(base.toString() + "/" + entity.getId(), PlayerInscription.class);
        PlayerInscriptionUtils.assertObjects(entity, playerInscription);
    }

    @Test
    public void getAllPlayerInscription() throws Exception {
        mongoTemplate.save(PlayerInscriptionUtils.createPlayerInscriptionEntity());
        mongoTemplate.save(PlayerInscriptionUtils.createPlayerInscriptionEntity());

        PlayerInscription[] playerInscriptions = template.getForObject(base.toString(), PlayerInscription[].class);
        assertEquals(2, playerInscriptions.length);
    }

    @Test
    public void testAddPlayerInscription() {
        PlayerInscription c = PlayerInscriptionUtils.createPlayerInscription("2");
        PlayerInscription playerInscription = template.postForObject(base.toString(), c, PlayerInscription.class);
        PlayerInscriptionUtils.assertObjects(c, playerInscription);

        PlayerInscriptionEntity entity =
                mongoTemplate.findById(playerInscription.getId(), PlayerInscriptionEntity.class);
        PlayerInscriptionUtils.assertObjects(entity, playerInscription);
    }

    @Test
    public void testUpdatePlayerInscription() {
        PlayerInscriptionEntity entity = PlayerInscriptionUtils.createPlayerInscriptionEntity();
        entity.setPlayerId("playerId");
        mongoTemplate.save(entity);

        PlayerInscription newPlayerInscription = PlayerInscriptionUtils.createPlayerInscription(entity.getId());
        newPlayerInscription.setPlayer(new Player().withId("playerId2"));
        HttpEntity<PlayerInscription> c = new HttpEntity<>(newPlayerInscription);
        ResponseEntity<PlayerInscription> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, PlayerInscription.class);
        PlayerInscriptionUtils.assertObjects(newPlayerInscription, response.getBody());
    }

    @Test
    public void deletePlayerInscription() throws Exception {
        PlayerInscriptionEntity entity = PlayerInscriptionUtils.createPlayerInscriptionEntity();
        mongoTemplate.save(entity);

        PlayerInscription[] playerInscriptions = template.getForObject(base.toString(), PlayerInscription[].class);
        assertEquals(1, playerInscriptions.length);

        template.delete(base.toString() + "/" + entity.getId());

        playerInscriptions = template.getForObject(base.toString(), PlayerInscription[].class);
        assertEquals(0, playerInscriptions.length);
    }
}
