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
import com.corujito.champz.rest.PlayerUtils;
import com.corujito.champz.rest.UserUtils;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.PlayerEntity;

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
public class PlayerResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/players");
        mongoTemplate.dropCollection(PlayerEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PlayerEntity.class);
    }

    @Test
    public void getPlayer() throws Exception {
        PlayerEntity entity = PlayerUtils.createPlayerEntity();
        mongoTemplate.save(entity);

        Player player = template.getForObject(base.toString() + "/" + entity.getId(), Player.class);
        PlayerUtils.assertObjects(entity, player);
    }

    @Test
    public void getAllPlayer() throws Exception {
        mongoTemplate.save(PlayerUtils.createPlayerEntity());
        mongoTemplate.save(PlayerUtils.createPlayerEntity());

        Player[] players = template.getForObject(base.toString(), Player[].class);
        assertEquals(2, players.length);
    }

    @Test
    public void testAddPlayer() {
        Player c = PlayerUtils.createPlayer();
        Player player = template.postForObject(base.toString(), c, Player.class);
        assertNotNull(player.getId());
        PlayerUtils.assertObjects(c, player);

        PlayerEntity entity = mongoTemplate.findById(player.getId(), PlayerEntity.class);
        PlayerUtils.assertObjects(entity, player);
    }

    @Test
    public void testUpdatePlayer() {
        PlayerEntity entity = PlayerUtils.createPlayerEntity();
        entity.setFullName("neymar");
        mongoTemplate.save(entity);

        Player newPlayer = PlayerUtils.createPlayer(entity.getId()).withFullName("neymar jr").withBirth(new Date())
                .withCpf("outro cpf").withNickName("nick").withPhotoImage("photo").withPopularName("popo")
                .withRg("outro rg").withUser(UserUtils.createUser("userId3"));
        HttpEntity<Player> c = new HttpEntity<>(newPlayer);
        ResponseEntity<Player> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Player.class);
        PlayerUtils.assertObjects(newPlayer, response.getBody());
    }

    @Test
    public void deletePlayer() throws Exception {
        PlayerEntity entity = PlayerUtils.createPlayerEntity();
        mongoTemplate.save(entity);

        Player[] players = template.getForObject(base.toString(), Player[].class);
        assertEquals(1, players.length);

        template.delete(base.toString() + "/" + entity.getId());

        players = template.getForObject(base.toString(), Player[].class);
        assertEquals(0, players.length);
    }
}
