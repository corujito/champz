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
import com.corujito.champz.rest.ParticipantUtils;
import com.corujito.champz.rest.model.Participant;
import com.corujito.champz.rest.model.Season;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.ParticipantEntity;

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
public class ParticipantResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/participants");
        mongoTemplate.dropCollection(ParticipantEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(ParticipantEntity.class);
    }

    @Test
    public void getParticipant() throws Exception {
        ParticipantEntity entity = ParticipantUtils.createParticipantEntity();
        mongoTemplate.save(entity);

        Participant participant = template.getForObject(base.toString() + "/" + entity.getId(), Participant.class);
        ParticipantUtils.assertObjects(entity, participant);
    }

    @Test
    public void getAllParticipant() throws Exception {
        mongoTemplate.save(ParticipantUtils.createParticipantEntity());
        mongoTemplate.save(ParticipantUtils.createParticipantEntity());

        Participant[] participants = template.getForObject(base.toString(), Participant[].class);
        assertEquals(2, participants.length);
    }

    @Test
    public void testAddParticipant() {
        Participant c = ParticipantUtils.createParticipant("2");
        Participant participant = template.postForObject(base.toString(), c, Participant.class);
        ParticipantUtils.assertObjects(c, participant);

        ParticipantEntity entity = mongoTemplate.findById(participant.getId(), ParticipantEntity.class);
        ParticipantUtils.assertObjects(entity, participant);
    }

    @Test
    public void testUpdateParticipant() {
        ParticipantEntity entity = ParticipantUtils.createParticipantEntity();
        entity.setSeasonId("seasonI");
        mongoTemplate.save(entity);

        Participant newParticipant = ParticipantUtils.createParticipant(entity.getId());
        Season season = new Season();
        season.setId("seasonId");
        newParticipant.setSeason(season);
        HttpEntity<Participant> c = new HttpEntity<>(newParticipant);
        ResponseEntity<Participant> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Participant.class);
        ParticipantUtils.assertObjects(newParticipant, response.getBody());
    }

    @Test
    public void deleteParticipant() throws Exception {
        ParticipantEntity entity = ParticipantUtils.createParticipantEntity();
        mongoTemplate.save(entity);

        Participant[] participants = template.getForObject(base.toString(), Participant[].class);
        assertEquals(1, participants.length);

        template.delete(base.toString() + "/" + entity.getId());

        participants = template.getForObject(base.toString(), Participant[].class);
        assertEquals(0, participants.length);
    }
}
