package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.PlayerMatchAttendance;
import com.corujito.champz.rest.repository.IAttendanceRepository;
import com.corujito.champz.rest.repository.entity.PlayerMatchAttendanceEntity;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IAttendanceRepository repository;

    @Override
    public PlayerMatchAttendance getAttendance(String id) {
        Optional<PlayerMatchAttendanceEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, PlayerMatchAttendance.class)).orElse(null);
    }

    @Override
    public List<PlayerMatchAttendance> getAllAttendances() {
        List<PlayerMatchAttendance> attendances = new ArrayList<>();
        List<PlayerMatchAttendanceEntity> entities = repository.findAll();
        for (PlayerMatchAttendanceEntity entity : entities) {
            attendances.add(modelMapper.map(entity, PlayerMatchAttendance.class));
        }
        return attendances;
    }

    @Override
    public PlayerMatchAttendance addAttendance(PlayerMatchAttendance attendance) {
        PlayerMatchAttendanceEntity entity = repository.save(modelMapper.map(attendance, PlayerMatchAttendanceEntity.class));
        return modelMapper.map(entity, PlayerMatchAttendance.class);
    }

    @Override
    public PlayerMatchAttendance updateAttendance(PlayerMatchAttendance attendance) {
        return addAttendance(attendance);
    }

    @Override
    public void deleteAttendance(String id) {
        repository.deleteById(id);
    }
}
