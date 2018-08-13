package com.corujito.champz.rest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.UserUtils;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.repository.IUserRepository;
import com.corujito.champz.rest.repository.entity.UserEntity;

@RunWith(MockitoJUnitRunner.class)
public class IUserServiceTest {

    @InjectMocks
    @Autowired
    UserServiceImpl userService;

    @Mock
    IUserRepository repository;

    @Test
    public void testGetUser() throws Exception {
        Optional<UserEntity> x = Optional.of(UserUtils.createUserEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        User user = userService.getUser("1");
        UserUtils.assertObjects(x.get(), user);
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        Optional<UserEntity> x = Optional.of(UserUtils.createUserEntity("1"));
        String email = "email";
        when(repository.findByEmail(email)).thenReturn(x);

        User user = userService.getUserByEmail(email);
        UserUtils.assertObjects(x.get(), user);
    }

    @Test
    public void testAddUser() {
        UserEntity c = UserUtils.createUserEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        User user = userService.addUser(new User());
        UserUtils.assertObjects(c, user);
    }

    @Test
    public void testUpdateUser() {
        UserEntity c = UserUtils.createUserEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        User user = userService.updateUser(new User());
        UserUtils.assertObjects(c, user);
    }

    @Test
    public void testGetAllUsers() {
        List<UserEntity> entities = Arrays.asList(UserUtils.createUserEntity("1"), UserUtils.createUserEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<User> users = userService.getAllUsers();
        assertEquals(users.size(), entities.size());
    }

    @Test
    public void testDelete() {
        userService.deleteUser("1");
        verify(repository, times(1)).deleteById("1");
    }
}
