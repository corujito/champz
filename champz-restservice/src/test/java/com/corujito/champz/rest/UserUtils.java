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
        return new UserEntity().withId(id).withName("name").withCpf("cpf").withEmail("email").withRg("rg");
    }

    public static User createUser() {
        return createUser(null);
    }

    public static User createUser(String id) {
        return new User().withId(id).withName("name").withCpf("cpf").withEmail("email").withRg("rg");
    }

    public static void assertObjects(UserEntity entity, User user) {
        assertThat(user.getId(), equalTo(entity.getId()));
        assertThat(user.getName(), equalTo(entity.getName()));
        assertThat(user.getEmail(), equalTo(entity.getEmail()));
        assertThat(user.getCpf(), equalTo(entity.getCpf()));
        assertThat(user.getRg(), equalTo(entity.getRg()));
    }

    public static void assertObjects(User c1, User c2) {
        // assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getName(), equalTo(c1.getName()));
        assertThat(c2.getEmail(), equalTo(c1.getEmail()));
        assertThat(c2.getCpf(), equalTo(c1.getCpf()));
        assertThat(c2.getRg(), equalTo(c1.getRg()));
    }
}
