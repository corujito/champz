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
import com.corujito.champz.rest.TeamUtils;
import com.corujito.champz.rest.UserUtils;
import com.corujito.champz.rest.model.Team;
import com.corujito.champz.rest.model.TeamType;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.TeamEntity;

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
public class TeamResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/teams");
        mongoTemplate.dropCollection(TeamEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(TeamEntity.class);
    }

    @Test
    public void getTeam() throws Exception {
        TeamEntity entity = TeamUtils.createTeamEntity();
        mongoTemplate.save(entity);

        Team team = template.getForObject(base.toString() + "/" + entity.getId(), Team.class);
        TeamUtils.assertObjects(entity, team);
    }

    @Test
    public void getAllTeam() throws Exception {
        mongoTemplate.save(TeamUtils.createTeamEntity());
        mongoTemplate.save(TeamUtils.createTeamEntity());

        Team[] teams = template.getForObject(base.toString(), Team[].class);
        assertEquals(2, teams.length);
    }

    @Test
    public void testAddTeam() {
        Team c = TeamUtils.createTeam();
        Team team = template.postForObject(base.toString(), c, Team.class);
        assertNotNull(team.getId());
        TeamUtils.assertObjects(c, team);

        TeamEntity entity = mongoTemplate.findById(team.getId(), TeamEntity.class);
        TeamUtils.assertObjects(entity, team);
    }

    @Test
    public void testUpdateTeam() {
        TeamEntity entity = TeamUtils.createTeamEntity();
        entity.setName("paulista");
        mongoTemplate.save(entity);

        Team newTeam = TeamUtils.createTeam(entity.getId()).withJerseyImage("jerseyy").withName("barcelona")
                .withNickname("barça").withPopularName("barcelona").withSymbolImage("symb").withType(TeamType.CLUB)
                .withUser(UserUtils.createUser("userIId"));
        HttpEntity<Team> c = new HttpEntity<>(newTeam);
        ResponseEntity<Team> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Team.class);
        TeamUtils.assertObjects(newTeam, response.getBody());
    }

    @Test
    public void deleteTeam() throws Exception {
        TeamEntity entity = TeamUtils.createTeamEntity();
        mongoTemplate.save(entity);

        Team[] teams = template.getForObject(base.toString(), Team[].class);
        assertEquals(1, teams.length);

        template.delete(base.toString() + "/" + entity.getId());

        teams = template.getForObject(base.toString(), Team[].class);
        assertEquals(0, teams.length);
    }
}
