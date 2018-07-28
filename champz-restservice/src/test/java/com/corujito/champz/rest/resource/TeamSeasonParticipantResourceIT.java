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
import com.corujito.champz.rest.TeamSeasonParticipantUtils;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.model.TeamSeasonParticipant;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.TeamSeasonParticipantEntity;

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
public class TeamSeasonParticipantResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/teamSeasonParticipants");
        mongoTemplate.dropCollection(TeamSeasonParticipantEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(TeamSeasonParticipantEntity.class);
    }

    @Test
    public void getTeamSeasonParticipant() throws Exception {
        TeamSeasonParticipantEntity entity = TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity();
        mongoTemplate.save(entity);

        TeamSeasonParticipant participant =
                template.getForObject(base.toString() + "/" + entity.getId(), TeamSeasonParticipant.class);
        TeamSeasonParticipantUtils.assertObjects(entity, participant);
    }

    @Test
    public void getAllTeamSeasonParticipant() throws Exception {
        mongoTemplate.save(TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity());
        mongoTemplate.save(TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity());

        TeamSeasonParticipant[] participants = template.getForObject(base.toString(), TeamSeasonParticipant[].class);
        assertEquals(2, participants.length);
    }

    @Test
    public void testAddTeamSeasonParticipant() {
        TeamSeasonParticipant c = TeamSeasonParticipantUtils.createTeamSeasonParticipant("2");
        TeamSeasonParticipant participant = template.postForObject(base.toString(), c, TeamSeasonParticipant.class);
        TeamSeasonParticipantUtils.assertObjects(c, participant);

        TeamSeasonParticipantEntity entity =
                mongoTemplate.findById(participant.getId(), TeamSeasonParticipantEntity.class);
        TeamSeasonParticipantUtils.assertObjects(entity, participant);
    }

    @Test
    public void testUpdateTeamSeasonParticipant() {
        TeamSeasonParticipantEntity entity = TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity();
        entity.setSeasonId("seasonI");
        mongoTemplate.save(entity);

        TeamSeasonParticipant newParticipant = TeamSeasonParticipantUtils.createTeamSeasonParticipant(entity.getId());
        Season season = new Season();
        season.setId("seasonId");
        newParticipant.setSeason(season);
        HttpEntity<TeamSeasonParticipant> c = new HttpEntity<>(newParticipant);
        ResponseEntity<TeamSeasonParticipant> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c,
                        TeamSeasonParticipant.class);
        TeamSeasonParticipantUtils.assertObjects(newParticipant, response.getBody());
    }

    @Test
    public void deleteTeamSeasonParticipant() throws Exception {
        TeamSeasonParticipantEntity entity = TeamSeasonParticipantUtils.createTeamSeasonParticipantEntity();
        mongoTemplate.save(entity);

        TeamSeasonParticipant[] participants = template.getForObject(base.toString(), TeamSeasonParticipant[].class);
        assertEquals(1, participants.length);

        template.delete(base.toString() + "/" + entity.getId());

        participants = template.getForObject(base.toString(), TeamSeasonParticipant[].class);
        assertEquals(0, participants.length);
    }
}
