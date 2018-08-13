package com.corujito.champz.rest.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PhaseEntity;

public interface IPhaseRepository extends MongoRepository<PhaseEntity, String> {

    List<PhaseEntity> findBySeasonId(String seasonId);

    Optional<PhaseEntity> findBySeasonIdAndName(String seasonId, String name);
}
