package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.SeasonEntity;

public interface ISeasonRepository extends MongoRepository<SeasonEntity, String> {

}
