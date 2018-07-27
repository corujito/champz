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
import com.corujito.champz.rest.model.Attendance;
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

        Attendance attendance = attendanceResource.getAttendance("1");
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testAddAttendance() {
        Attendance c = AttendanceUtils.createAttendance("1");
        when(attendanceService.addAttendance(c)).thenReturn(c);

        Attendance attendance = attendanceResource.addAttendance(c);
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testUpdateAttendance() {
        Attendance c = AttendanceUtils.createAttendance("1");
        when(attendanceService.updateAttendance(c)).thenReturn(c);

        Attendance attendance = attendanceResource.updateAttendance(c.getId(), c);
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testGetAllAttendances() {
        List<Attendance> list =
                Arrays.asList(AttendanceUtils.createAttendance("1"), AttendanceUtils.createAttendance("2"));
        when(attendanceService.getAllAttendances()).thenReturn(list);

        List<Attendance> attendances = attendanceResource.getAllAttendances();
        assertEquals(attendances.size(), list.size());
    }

    @Test
    public void testDelete() {
        attendanceResource.deleteAttendance("1");
        verify(attendanceService, times(1)).deleteAttendance("1");
    }
}
