package com.corujito.champz.rest.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.GroupEntity;

public interface IGroupRepository extends MongoRepository<GroupEntity, String> {

    List<GroupEntity> findByPhaseId(String phaseId);

    Optional<GroupEntity> findByPhaseIdAndName(String phaseId, String name);

}
