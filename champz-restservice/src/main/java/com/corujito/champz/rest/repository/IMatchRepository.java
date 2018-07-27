package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.MatchEntity;

public interface IMatchRepository extends MongoRepository<MatchEntity, String> {

}
