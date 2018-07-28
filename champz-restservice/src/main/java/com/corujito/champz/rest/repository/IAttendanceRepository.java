package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PlayerMatchAttendanceEntity;

public interface IAttendanceRepository extends MongoRepository<PlayerMatchAttendanceEntity, String> {

}
