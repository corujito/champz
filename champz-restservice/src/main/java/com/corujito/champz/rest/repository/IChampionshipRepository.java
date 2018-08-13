package com.corujito.champz.rest.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

public interface IChampionshipRepository extends MongoRepository<ChampionshipEntity, String> {

    Optional<ChampionshipEntity> findByUserIdAndName(String userId, String name);

}
