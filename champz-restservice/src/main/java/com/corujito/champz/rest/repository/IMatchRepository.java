package com.corujito.champz.rest.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.MatchEntity;

public interface IMatchRepository extends MongoRepository<MatchEntity, String> {

    List<MatchEntity> findBySeasonId(String seasonId);

}
