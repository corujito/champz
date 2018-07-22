package com.corujito.champz.rest.resource;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
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
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.corujito.champz.rest.Application;
import com.corujito.champz.rest.model.Championship;
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
        ChampionshipEntity entity = new ChampionshipEntity();
        entity.setName("name");
        entity.setDescription("description");
        mongoTemplate.save(entity);

        ResponseEntity<Championship> response =
                template.getForEntity(base.toString() + "/" + entity.getId(), Championship.class);
        Championship championship = response.getBody();
        assertThat(championship.getId(), equalTo(entity.getId()));
        assertThat(championship.getName(), equalTo(entity.getName()));
        assertThat(championship.getDescription(), equalTo(entity.getDescription()));
    }
}
