package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Attendance;
import com.corujito.champz.rest.repository.IAttendanceRepository;
import com.corujito.champz.rest.repository.entity.AttendanceEntity;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IAttendanceRepository repository;

    @Override
    public Attendance getAttendance(String id) {
        Optional<AttendanceEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, Attendance.class)).orElse(null);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        List<Attendance> attendances = new ArrayList<>();
        List<AttendanceEntity> entities = repository.findAll();
        for (AttendanceEntity entity : entities) {
            attendances.add(modelMapper.map(entity, Attendance.class));
        }
        return attendances;
    }

    @Override
    public Attendance addAttendance(Attendance attendance) {
        AttendanceEntity entity = repository.save(modelMapper.map(attendance, AttendanceEntity.class));
        return modelMapper.map(entity, Attendance.class);
    }

    @Override
    public Attendance updateAttendance(Attendance attendance) {
        return addAttendance(attendance);
    }

    @Override
    public void deleteAttendance(String id) {
        repository.deleteById(id);
    }
}
