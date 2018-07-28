package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PhaseEntity;

public interface IPhaseRepository extends MongoRepository<PhaseEntity, String> {

}
