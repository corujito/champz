package com.corujito.champz.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Date;
import com.corujito.champz.rest.model.Player;
import com.corujito.champz.rest.repository.entity.PlayerEntity;

public class PlayerUtils {

    public static PlayerEntity createPlayerEntity() {
        return createPlayerEntity(null);
    }

    public static PlayerEntity createPlayerEntity(String id) {
        return new PlayerEntity().withId(id).withUserId("1").withBirth(new Date())
                .withFullName("fullName").withPopularName("popularName").withPhotoImage("photo").withCpf("cpf")
                .withRg("rg").withNickName("nickname");
    }

    public static Player createPlayer() {
        return createPlayer(null);
    }

    public static Player createPlayer(String id) {
        return new Player().withId(id).withUser(UserUtils.createUser("userId")).withBirth(new Date())
                .withFullName("fullName").withPopularName("popularName").withPhotoImage("photo").withCpf("cpf")
                .withRg("rg").withNickName("nickname");
    }

    public static void assertObjects(PlayerEntity entity, Player player) {
        assertThat(player.getId(), equalTo(entity.getId()));
        assertThat(player.getFullName(), equalTo(entity.getFullName()));
        assertThat(player.getPopularName(), equalTo(entity.getPopularName()));
        assertThat(player.getBirth(), equalTo(entity.getBirth()));
        assertThat(player.getBirthLocation(), equalTo(entity.getBirthLocation()));
        assertThat(player.getPhotoImage(), equalTo(entity.getPhotoImage()));
        assertThat(player.getCpf(), equalTo(entity.getCpf()));
        assertThat(player.getRg(), equalTo(entity.getRg()));
        assertThat(player.getNickName(), equalTo(entity.getNickName()));
        assertThat(player.getUser().getId(), equalTo(entity.getUserId()));
    }

    public static void assertObjects(Player c1, Player c2) {
        // assertThat(c2.getId(), equalTo(c1.getId()));
        assertThat(c2.getFullName(), equalTo(c1.getFullName()));
        assertThat(c2.getPopularName(), equalTo(c1.getPopularName()));
        assertThat(c2.getBirth(), equalTo(c1.getBirth()));
        assertThat(c2.getBirthLocation(), equalTo(c1.getBirthLocation()));
        assertThat(c2.getPhotoImage(), equalTo(c1.getPhotoImage()));
        assertThat(c2.getCpf(), equalTo(c1.getCpf()));
        assertThat(c2.getRg(), equalTo(c1.getRg()));
        assertThat(c2.getNickName(), equalTo(c1.getNickName()));
        assertThat(c2.getUser().getId(), equalTo(c1.getUser().getId()));
    }
}
