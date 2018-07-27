package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.repository.entity.PlayerEntity;
import com.corujito.champz.rest.repository.entity.UserEntity;

public class PlayerUtils {

    public static PlayerEntity createPlayerEntity() {
        return createPlayerEntity(null);
    }

    public static PlayerEntity createPlayerEntity(String id) {
        PlayerEntity entity = new PlayerEntity();
        entity.setId(id);
        UserEntity user = new UserEntity();
        user.setId("1");
        user.setEmail("email");
        entity.setUserId("1");
        return entity;
    }

    public static Player createPlayer(String id) {
        Player player = new Player();
        player.setId(id);
        User user = new User();
        user.setId("1");
        user.setEmail("email");
        player.setUser(user);
        return player;
    }

    public static void assertObjects(PlayerEntity entity, Player player) {
        assertThat(player.getId(), equalTo(entity.getId()));
        assertThat(player.getFullName(), equalTo(entity.getFullName()));
        assertThat(player.getPopularName(), equalTo(entity.getPopularName()));
        assertThat(player.getBirth(), equalTo(entity.getBirth()));
        assertThat(player.getBirthLocation(), equalTo(entity.getBirthLocation()));
        assertThat(player.getPhotoImage(), equalTo(entity.getPhotoImage()));
        assertThat(player.getUser().getId(), equalTo(entity.getUserId()));
    }

    public static void assertObjects(Player c1, Player c2) {
        assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getFullName(), equalTo(c1.getFullName()));
        assertThat(c2.getPopularName(), equalTo(c1.getPopularName()));
        assertThat(c2.getBirth(), equalTo(c1.getBirth()));
        assertThat(c2.getBirthLocation(), equalTo(c1.getBirthLocation()));
        assertThat(c2.getPhotoImage(), equalTo(c1.getPhotoImage()));
        assertThat(c2.getUser().getId(), equalTo(c1.getUser().getId()));
    }
}
