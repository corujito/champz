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
import com.corujito.champz.rest.MatchUtils;
import com.corujito.champz.rest.model.Match;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.MatchEntity;

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
public class MatchResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/matches");
        mongoTemplate.dropCollection(MatchEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(MatchEntity.class);
    }

    @Test
    public void getMatch() throws Exception {
        MatchEntity entity = MatchUtils.createMatchEntity();
        mongoTemplate.save(entity);

        Match match = template.getForObject(base.toString() + "/" + entity.getId(), Match.class);
        MatchUtils.assertObjects(entity, match);
    }

    @Test
    public void getAllMatch() throws Exception {
        mongoTemplate.save(MatchUtils.createMatchEntity());
        mongoTemplate.save(MatchUtils.createMatchEntity());

        Match[] matchs = template.getForObject(base.toString(), Match[].class);
        assertEquals(2, matchs.length);
    }

    @Test
    public void testAddMatch() {
        Match c = MatchUtils.createMatch();
        Match match = template.postForObject(base.toString(), c, Match.class);
        assertNotNull(match.getId());
        MatchUtils.assertObjects(c, match);

        MatchEntity entity = mongoTemplate.findById(match.getId(), MatchEntity.class);
        MatchUtils.assertObjects(entity, match);
    }

    @Test
    public void testUpdateMatch() {
        MatchEntity entity = MatchUtils.createMatchEntity();
        entity.setHomeScore(22);
        mongoTemplate.save(entity);

        Match newMatch = MatchUtils.createMatch(entity.getId()).withAwayExtraTimeScore(1).withAwayPenaltyScore(2)
                .withAwayScore(3);
        HttpEntity<Match> c = new HttpEntity<>(newMatch);
        ResponseEntity<Match> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Match.class);
        MatchUtils.assertObjects(newMatch, response.getBody());
    }

    @Test
    public void deleteMatch() throws Exception {
        MatchEntity entity = MatchUtils.createMatchEntity();
        mongoTemplate.save(entity);

        Match[] matchs = template.getForObject(base.toString(), Match[].class);
        assertEquals(1, matchs.length);

        template.delete(base.toString() + "/" + entity.getId());

        matchs = template.getForObject(base.toString(), Match[].class);
        assertEquals(0, matchs.length);
    }
}
