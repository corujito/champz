package com.corujito.champz.rest.service;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.AttendanceUtils;
import com.corujito.champz.rest.model.PlayerMatchAttendance;
import com.corujito.champz.rest.repository.IAttendanceRepository;
import com.corujito.champz.rest.repository.entity.PlayerMatchAttendanceEntity;

@RunWith(MockitoJUnitRunner.class)
public class IAttendanceServiceTest {

    @InjectMocks
    @Autowired
    AttendanceServiceImpl attendanceService;

    @Mock
    IAttendanceRepository repository;

    @Test
    public void testGetAttendance() throws Exception {
        Optional<PlayerMatchAttendanceEntity> x = Optional.of(AttendanceUtils.createAttendanceEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        PlayerMatchAttendance attendance = attendanceService.getAttendance("1");
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testAddAttendance() {
        PlayerMatchAttendanceEntity c = AttendanceUtils.createAttendanceEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        PlayerMatchAttendance attendance = attendanceService.addAttendance(new PlayerMatchAttendance());
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testUpdateAttendance() {
        PlayerMatchAttendanceEntity c = AttendanceUtils.createAttendanceEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        PlayerMatchAttendance attendance = attendanceService.updateAttendance(new PlayerMatchAttendance());
        assertThat(attendance, notNullValue());
    }

    @Test
    public void testGetAllAttendances() {
        List<PlayerMatchAttendanceEntity> entities = Arrays.asList(AttendanceUtils.createAttendanceEntity("1"),
                AttendanceUtils.createAttendanceEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<PlayerMatchAttendance> attendances = attendanceService.getAllAttendances();
        assertEquals(attendances.size(), entities.size());
    }

    @Test
    public void testDelete() {
        attendanceService.deleteAttendance("1");
        verify(repository, times(1)).deleteById("1");
    }
}
