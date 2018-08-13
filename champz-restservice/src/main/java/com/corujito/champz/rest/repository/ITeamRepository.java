package com.corujito.champz.rest.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.TeamEntity;

public interface ITeamRepository extends MongoRepository<TeamEntity, String> {

    Optional<TeamEntity> findByUserIdAndPopularName(String userId, String popularName);

}
