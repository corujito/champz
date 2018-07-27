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
import com.corujito.champz.rest.UserUtils;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.UserEntity;

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
public class UserResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/users");
        mongoTemplate.dropCollection(UserEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(UserEntity.class);
    }

    @Test
    public void getUser() throws Exception {
        UserEntity entity = UserUtils.createUserEntity();
        mongoTemplate.save(entity);

        User user = template.getForObject(base.toString() + "/" + entity.getId(), User.class);
        UserUtils.assertObjects(entity, user);
    }

    @Test
    public void getAllUser() throws Exception {
        mongoTemplate.save(UserUtils.createUserEntity());
        mongoTemplate.save(UserUtils.createUserEntity());

        User[] users = template.getForObject(base.toString(), User[].class);
        assertEquals(2, users.length);
    }

    @Test
    public void testAddUser() {
        User c = UserUtils.createUser("2");
        User user = template.postForObject(base.toString(), c, User.class);
        UserUtils.assertObjects(c, user);

        UserEntity entity = mongoTemplate.findById(user.getId(), UserEntity.class);
        UserUtils.assertObjects(entity, user);
    }

    @Test
    public void testUpdateUser() {
        UserEntity entity = UserUtils.createUserEntity();
        entity.setName("campeonato brasileiro");
        mongoTemplate.save(entity);

        User newUser = UserUtils.createUser(entity.getId());
        newUser.setName("campeonato paulista");
        HttpEntity<User> c = new HttpEntity<>(newUser);
        ResponseEntity<User> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, User.class);
        UserUtils.assertObjects(newUser, response.getBody());
    }

    @Test
    public void deleteUser() throws Exception {
        UserEntity entity = UserUtils.createUserEntity();
        mongoTemplate.save(entity);

        User[] users = template.getForObject(base.toString(), User[].class);
        assertEquals(1, users.length);

        template.delete(base.toString() + "/" + entity.getId());

        users = template.getForObject(base.toString(), User[].class);
        assertEquals(0, users.length);
    }
}
