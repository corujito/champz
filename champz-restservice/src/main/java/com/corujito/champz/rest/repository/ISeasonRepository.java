package com.corujito.champz.rest.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.SeasonEntity;

public interface ISeasonRepository extends MongoRepository<SeasonEntity, String> {

    Optional<SeasonEntity> findByChampionshipIdAndTitle(String championshipId, String title);

}
