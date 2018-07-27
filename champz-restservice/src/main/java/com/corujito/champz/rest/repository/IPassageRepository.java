package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PassageEntity;

public interface IPassageRepository extends MongoRepository<PassageEntity, String> {

}
