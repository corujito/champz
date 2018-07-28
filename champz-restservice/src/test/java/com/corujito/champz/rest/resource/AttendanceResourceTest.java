package com.corujito.champz.rest.resource;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.AttendanceUtils;
import com.corujito.champz.rest.model.PlayerMatchAttendance;
import com.corujito.champz.rest.service.IAttendanceService;

@RunWith(MockitoJUnitRunner.class)
public class AttendanceResourceTest {

    @InjectMocks
    @Autowired
    AttendanceResource attendanceResource;

    @Mock
    IAttendanceService attendanceService;

    @Before
    public void before() {}

    @Test
    public void testGetAttendance() throws Exception {
        when(attendanceService.getAttendance("1")).thenReturn(AttendanceUtils.createAttendance("1"));

        PlayerMatchAttendance attendance = attendanceResource.getAttendance("1");
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testAddAttendance() {
        PlayerMatchAttendance c = AttendanceUtils.createAttendance("1");
        when(attendanceService.addAttendance(c)).thenReturn(c);

        PlayerMatchAttendance attendance = attendanceResource.addAttendance(c);
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testUpdateAttendance() {
        PlayerMatchAttendance c = AttendanceUtils.createAttendance("1");
        when(attendanceService.updateAttendance(c)).thenReturn(c);

        PlayerMatchAttendance attendance = attendanceResource.updateAttendance(c.getId(), c);
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testGetAllAttendances() {
        List<PlayerMatchAttendance> list =
                Arrays.asList(AttendanceUtils.createAttendance("1"), AttendanceUtils.createAttendance("2"));
        when(attendanceService.getAllAttendances()).thenReturn(list);

        List<PlayerMatchAttendance> attendances = attendanceResource.getAllAttendances();
        assertEquals(attendances.size(), list.size());
    }

    @Test
    public void testDelete() {
        attendanceResource.deleteAttendance("1");
        verify(attendanceService, times(1)).deleteAttendance("1");
    }
}
