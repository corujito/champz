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
import com.corujito.champz.rest.GroupUtils;
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.GroupEntity;

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
public class GroupResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/groups");
        mongoTemplate.dropCollection(GroupEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(GroupEntity.class);
    }

    @Test
    public void getGroup() throws Exception {
        GroupEntity entity = GroupUtils.createGroupEntity();
        mongoTemplate.save(entity);

        Group group = template.getForObject(base.toString() + "/" + entity.getId(), Group.class);
        GroupUtils.assertObjects(entity, group);
    }

    @Test
    public void getAllGroup() throws Exception {
        mongoTemplate.save(GroupUtils.createGroupEntity());
        mongoTemplate.save(GroupUtils.createGroupEntity());

        Group[] groups = template.getForObject(base.toString(), Group[].class);
        assertEquals(2, groups.length);
    }

    @Test
    public void testAddGroup() {
        Group c = GroupUtils.createGroup();
        Group group = template.postForObject(base.toString(), c, Group.class);
        assertNotNull(group.getId());
        GroupUtils.assertObjects(c, group);

        GroupEntity entity = mongoTemplate.findById(group.getId(), GroupEntity.class);
        GroupUtils.assertObjects(entity, group);
    }

    @Test
    public void testUpdateGroup() {
        GroupEntity entity = GroupUtils.createGroupEntity();
        entity.setName("campeonato brasileiro");
        mongoTemplate.save(entity);

        Group newGroup = GroupUtils.createGroup(entity.getId());
        newGroup.setName("campeonato paulista");
        HttpEntity<Group> c = new HttpEntity<>(newGroup);
        ResponseEntity<Group> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Group.class);
        GroupUtils.assertObjects(newGroup, response.getBody());
    }

    @Test
    public void deleteGroup() throws Exception {
        GroupEntity entity = GroupUtils.createGroupEntity();
        mongoTemplate.save(entity);

        Group[] groups = template.getForObject(base.toString(), Group[].class);
        assertEquals(1, groups.length);

        template.delete(base.toString() + "/" + entity.getId());

        groups = template.getForObject(base.toString(), Group[].class);
        assertEquals(0, groups.length);
    }
}
