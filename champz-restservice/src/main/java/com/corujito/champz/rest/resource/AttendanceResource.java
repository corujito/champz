package com.corujito.champz.rest.resource;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corujito.champz.rest.model.PlayerMatchAttendance;
import com.corujito.champz.rest.service.IAttendanceService;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceResource.class);

    @Autowired
    IAttendanceService attendanceService;

    @GetMapping(path = "/{id}")
    public PlayerMatchAttendance getAttendance(@PathVariable String id) {
        LOGGER.debug("Attendance.getAttendance {}", id);
        return attendanceService.getAttendance(id);
    }

    @GetMapping
    public List<PlayerMatchAttendance> getAllAttendances() {
        LOGGER.debug("Attendance.getAllAttendances");
        return attendanceService.getAllAttendances();
    }

    @PostMapping
    public PlayerMatchAttendance addAttendance(
            @RequestBody @Validated({PlayerMatchAttendance.New.class}) PlayerMatchAttendance attendance) {
        LOGGER.debug("Attendance.addAttendance");
        return attendanceService.addAttendance(attendance);
    }

    @PutMapping(path = "/{id}")
    public PlayerMatchAttendance updateAttendance(@PathVariable String id,
            @RequestBody @Validated({PlayerMatchAttendance.Existing.class}) PlayerMatchAttendance attendance) {
        LOGGER.debug("Attendance.updateAttendance {}", id);
        return attendanceService.updateAttendance(attendance);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAttendance(@PathVariable String id) {
        LOGGER.debug("Attendance.deleteAttendance {}", id);
        attendanceService.deleteAttendance(id);
    }

}
