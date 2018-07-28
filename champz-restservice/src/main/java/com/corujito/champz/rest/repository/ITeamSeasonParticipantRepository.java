package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.TeamSeasonParticipantEntity;

public interface ITeamSeasonParticipantRepository extends MongoRepository<TeamSeasonParticipantEntity, String> {

}
