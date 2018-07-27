package com.corujito.champz.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.corujito.champz.rest.repository.entity.UserEntity;

public interface IUserRepository extends MongoRepository<UserEntity, String> {

}
