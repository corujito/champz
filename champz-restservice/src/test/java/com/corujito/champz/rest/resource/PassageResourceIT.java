package com.corujito.champz.rest.resource;

import static org.junit.Assert.assertEquals;
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
import com.corujito.champz.rest.PassageUtils;
import com.corujito.champz.rest.model.Passage;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.PassageEntity;

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
public class PassageResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/passages");
        mongoTemplate.dropCollection(PassageEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PassageEntity.class);
    }

    @Test
    public void getPassage() throws Exception {
        PassageEntity entity = PassageUtils.createPassageEntity();
        mongoTemplate.save(entity);

        Passage passage = template.getForObject(base.toString() + "/" + entity.getId(), Passage.class);
        PassageUtils.assertObjects(entity, passage);
    }

    @Test
    public void getAllPassage() throws Exception {
        mongoTemplate.save(PassageUtils.createPassageEntity());
        mongoTemplate.save(PassageUtils.createPassageEntity());

        Passage[] passages = template.getForObject(base.toString(), Passage[].class);
        assertEquals(2, passages.length);
    }

    @Test
    public void testAddPassage() {
        Passage c = PassageUtils.createPassage("2");
        Passage passage = template.postForObject(base.toString(), c, Passage.class);
        PassageUtils.assertObjects(c, passage);

        PassageEntity entity = mongoTemplate.findById(passage.getId(), PassageEntity.class);
        PassageUtils.assertObjects(entity, passage);
    }

    @Test
    public void testUpdatePassage() {
        PassageEntity entity = PassageUtils.createPassageEntity();
        entity.setBegin(new Date());
        mongoTemplate.save(entity);

        Passage newPassage = PassageUtils.createPassage(entity.getId());
        newPassage.setBegin(new Date());
        HttpEntity<Passage> c = new HttpEntity<>(newPassage);
        ResponseEntity<Passage> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Passage.class);
        PassageUtils.assertObjects(newPassage, response.getBody());
    }

    @Test
    public void deletePassage() throws Exception {
        PassageEntity entity = PassageUtils.createPassageEntity();
        mongoTemplate.save(entity);

        Passage[] passages = template.getForObject(base.toString(), Passage[].class);
        assertEquals(1, passages.length);

        template.delete(base.toString() + "/" + entity.getId());

        passages = template.getForObject(base.toString(), Passage[].class);
        assertEquals(0, passages.length);
    }
}
