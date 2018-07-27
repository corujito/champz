package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.repository.entity.UserEntity;

public class UserUtils {

    public static UserEntity createUserEntity() {
        return createUserEntity(null);
    }

    public static UserEntity createUserEntity(String id) {
        UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setName("name");
        return entity;
    }

    public static User createUser(String id) {
        User user = new User();
        user.setId(id);
        user.setName("name");
        return user;
    }

    public static void assertObjects(UserEntity entity, User user) {
        assertThat(user.getId(), equalTo(entity.getId()));
        assertThat(user.getName(), equalTo(entity.getName()));
    }

    public static void assertObjects(User c1, User c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
    }
}
