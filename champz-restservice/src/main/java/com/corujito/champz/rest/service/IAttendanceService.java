package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Attendance;

public interface IAttendanceService {

    Attendance getAttendance(String id);

    List<Attendance> getAllAttendances();

    Attendance addAttendance(Attendance attendance);

    Attendance updateAttendance(Attendance attendance);

    void deleteAttendance(String id);
}
