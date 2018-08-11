package com.corujito.champz.rest.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.TeamSeasonParticipantEntity;

public interface ITeamSeasonParticipantRepository extends MongoRepository<TeamSeasonParticipantEntity, String> {

    List<TeamSeasonParticipantEntity> findBySeasonId(String seasonId);

}
