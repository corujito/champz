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
import com.corujito.champz.rest.AttendanceUtils;
import com.corujito.champz.rest.model.PlayerMatchAttendance;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.PlayerMatchAttendanceEntity;

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
public class AttendanceResourceIT {

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
        this.base = new URL("http://localhost:" + port + "/api/attendances");
        mongoTemplate.dropCollection(PlayerMatchAttendanceEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PlayerMatchAttendanceEntity.class);
    }

    @Test
    public void getAttendance() throws Exception {
        PlayerMatchAttendanceEntity entity = AttendanceUtils.createAttendanceEntity();
        mongoTemplate.save(entity);

        PlayerMatchAttendance attendance = template.getForObject(base.toString() + "/" + entity.getId(), PlayerMatchAttendance.class);
        AttendanceUtils.assertObjects(entity, attendance);
    }

    @Test
    public void getAllAttendance() throws Exception {
        mongoTemplate.save(AttendanceUtils.createAttendanceEntity());
        mongoTemplate.save(AttendanceUtils.createAttendanceEntity());

        PlayerMatchAttendance[] attendances = template.getForObject(base.toString(), PlayerMatchAttendance[].class);
        assertEquals(2, attendances.length);
    }

    @Test
    public void testAddAttendance() {
        PlayerMatchAttendance c = AttendanceUtils.createAttendance("2");
        PlayerMatchAttendance attendance = template.postForObject(base.toString(), c, PlayerMatchAttendance.class);
        AttendanceUtils.assertObjects(c, attendance);

        PlayerMatchAttendanceEntity entity = mongoTemplate.findById(attendance.getId(), PlayerMatchAttendanceEntity.class);
        AttendanceUtils.assertObjects(entity, attendance);
    }

    @Test
    public void testUpdateAttendance() {
        PlayerMatchAttendanceEntity entity = AttendanceUtils.createAttendanceEntity();
        entity.setPosition("atacante");
        mongoTemplate.save(entity);

        PlayerMatchAttendance newAttendance = AttendanceUtils.createAttendance(entity.getId());
        newAttendance.setPosition("goleiro");
        HttpEntity<PlayerMatchAttendance> c = new HttpEntity<>(newAttendance);
        ResponseEntity<PlayerMatchAttendance> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, PlayerMatchAttendance.class);
        AttendanceUtils.assertObjects(newAttendance, response.getBody());
    }

    @Test
    public void deleteAttendance() throws Exception {
        PlayerMatchAttendanceEntity entity = AttendanceUtils.createAttendanceEntity();
        mongoTemplate.save(entity);

        PlayerMatchAttendance[] attendances = template.getForObject(base.toString(), PlayerMatchAttendance[].class);
        assertEquals(1, attendances.length);

        template.delete(base.toString() + "/" + entity.getId());

        attendances = template.getForObject(base.toString(), PlayerMatchAttendance[].class);
        assertEquals(0, attendances.length);
    }
}
