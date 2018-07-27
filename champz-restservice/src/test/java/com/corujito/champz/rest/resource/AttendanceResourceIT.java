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
import com.corujito.champz.rest.model.Attendance;
import com.corujito.champz.rest.repository.config.MongoConfigIT;
import com.corujito.champz.rest.repository.entity.AttendanceEntity;

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
        mongoTemplate.dropCollection(AttendanceEntity.class);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(AttendanceEntity.class);
    }

    @Test
    public void getAttendance() throws Exception {
        AttendanceEntity entity = AttendanceUtils.createAttendanceEntity();
        mongoTemplate.save(entity);

        Attendance attendance = template.getForObject(base.toString() + "/" + entity.getId(), Attendance.class);
        AttendanceUtils.assertObjects(entity, attendance);
    }

    @Test
    public void getAllAttendance() throws Exception {
        mongoTemplate.save(AttendanceUtils.createAttendanceEntity());
        mongoTemplate.save(AttendanceUtils.createAttendanceEntity());

        Attendance[] attendances = template.getForObject(base.toString(), Attendance[].class);
        assertEquals(2, attendances.length);
    }

    @Test
    public void testAddAttendance() {
        Attendance c = AttendanceUtils.createAttendance("2");
        Attendance attendance = template.postForObject(base.toString(), c, Attendance.class);
        AttendanceUtils.assertObjects(c, attendance);

        AttendanceEntity entity = mongoTemplate.findById(attendance.getId(), AttendanceEntity.class);
        AttendanceUtils.assertObjects(entity, attendance);
    }

    @Test
    public void testUpdateAttendance() {
        AttendanceEntity entity = AttendanceUtils.createAttendanceEntity();
        entity.setPosition("atacante");
        mongoTemplate.save(entity);

        Attendance newAttendance = AttendanceUtils.createAttendance(entity.getId());
        newAttendance.setPosition("goleiro");
        HttpEntity<Attendance> c = new HttpEntity<>(newAttendance);
        ResponseEntity<Attendance> response =
                template.exchange(base.toString() + "/" + entity.getId(), HttpMethod.PUT, c, Attendance.class);
        AttendanceUtils.assertObjects(newAttendance, response.getBody());
    }

    @Test
    public void deleteAttendance() throws Exception {
        AttendanceEntity entity = AttendanceUtils.createAttendanceEntity();
        mongoTemplate.save(entity);

        Attendance[] attendances = template.getForObject(base.toString(), Attendance[].class);
        assertEquals(1, attendances.length);

        template.delete(base.toString() + "/" + entity.getId());

        attendances = template.getForObject(base.toString(), Attendance[].class);
        assertEquals(0, attendances.length);
    }
}
