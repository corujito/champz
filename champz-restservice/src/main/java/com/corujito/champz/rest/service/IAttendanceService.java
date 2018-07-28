package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.PlayerMatchAttendance;

public interface IAttendanceService {

    PlayerMatchAttendance getAttendance(String id);

    List<PlayerMatchAttendance> getAllAttendances();

    PlayerMatchAttendance addAttendance(PlayerMatchAttendance attendance);

    PlayerMatchAttendance updateAttendance(PlayerMatchAttendance attendance);

    void deleteAttendance(String id);
}
