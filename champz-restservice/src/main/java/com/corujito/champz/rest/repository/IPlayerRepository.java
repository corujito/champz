package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PlayerEntity;

public interface IPlayerRepository extends MongoRepository<PlayerEntity, String> {

}
