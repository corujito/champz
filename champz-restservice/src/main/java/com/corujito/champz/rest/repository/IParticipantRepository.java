package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.ParticipantEntity;

public interface IParticipantRepository extends MongoRepository<ParticipantEntity, String> {

}
