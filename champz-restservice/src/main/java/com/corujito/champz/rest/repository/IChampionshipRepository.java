package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.ChampionshipEntity;

public interface IChampionshipRepository extends MongoRepository<ChampionshipEntity, String> {

}
