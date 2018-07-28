package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.GroupEntity;

public interface IGroupRepository extends MongoRepository<GroupEntity, String> {

}
