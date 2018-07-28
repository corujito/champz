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
import com.corujito.champz.rest.PhaseUtils;
import com.corujito.champz.rest.model.Phase;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.PhaseEntity;

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
public class PhaseResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/phases");
        mongoTemplate.dropCollection(PhaseEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PhaseEntity.class);
    }

    @Test
    public void getPhase() throws Exception {
        PhaseEntity entity = PhaseUtils.createPhaseEntity();
        mongoTemplate.save(entity);

        Phase phase = template.getForObject(base.toString() + "/" + entity.getId(), Phase.class);
        PhaseUtils.assertObjects(entity, phase);
    }

    @Test
    public void getAllPhase() throws Exception {
        mongoTemplate.save(PhaseUtils.createPhaseEntity());
        mongoTemplate.save(PhaseUtils.createPhaseEntity());

        Phase[] phases = template.getForObject(base.toString(), Phase[].class);
        assertEquals(2, phases.length);
    }

    @Test
    public void testAddPhase() {
        Phase c = PhaseUtils.createPhase("2");
        Phase phase = template.postForObject(base.toString(), c, Phase.class);
        PhaseUtils.assertObjects(c, phase);

        PhaseEntity entity = mongoTemplate.findById(phase.getId(), PhaseEntity.class);
        PhaseUtils.assertObjects(entity, phase);
    }

    @Test
    public void testUpdatePhase() {
        PhaseEntity entity = PhaseUtils.createPhaseEntity();
        entity.setName("campeonato brasileiro");
        mongoTemplate.save(entity);

        Phase newPhase = PhaseUtils.createPhase(entity.getId());
        newPhase.setName("campeonato paulista");
        HttpEntity<Phase> c = new HttpEntity<>(newPhase);
        ResponseEntity<Phase> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Phase.class);
        PhaseUtils.assertObjects(newPhase, response.getBody());
    }

    @Test
    public void deletePhase() throws Exception {
        PhaseEntity entity = PhaseUtils.createPhaseEntity();
        mongoTemplate.save(entity);

        Phase[] phases = template.getForObject(base.toString(), Phase[].class);
        assertEquals(1, phases.length);

        template.delete(base.toString() + "/" + entity.getId());

        phases = template.getForObject(base.toString(), Phase[].class);
        assertEquals(0, phases.length);
    }
}
