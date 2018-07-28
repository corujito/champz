package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.PlayerTeamPassageEntity;

public interface IPlayerTeamPassageRepository extends MongoRepository<PlayerTeamPassageEntity, String> {

}
