package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PlayerInscriptionEntity;

public interface IPlayerInscriptionRepository extends MongoRepository<PlayerInscriptionEntity, String> {

}
