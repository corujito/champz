package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PlayEntity;

public interface IPlayRepository extends MongoRepository<PlayEntity, String> {

}
