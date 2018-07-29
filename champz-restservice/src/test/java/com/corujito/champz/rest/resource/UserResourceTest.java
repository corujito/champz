package com.corujito.champz.rest.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.corujito.champz.rest.UserUtils;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.service.IUserService;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest {

    @InjectMocks
    @Autowired
    UserResource userResource;

    @Mock
    IUserService userService;

    @Before
    public void before() {}

    @Test
    public void testGetUser() throws Exception {
        User c = UserUtils.createUser("1");
        when(userService.getUser("1")).thenReturn(c);

        User user = userResource.getUser("1");
        UserUtils.assertObjects(user, c);
    }

    @Test
    public void testAddUser() {
        User c = UserUtils.createUser("1");
        when(userService.addUser(c)).thenReturn(c);

        User user = userResource.addUser(c);
        UserUtils.assertObjects(user, c);
    }

    @Test
    public void testUpdateUser() {
        User c = UserUtils.createUser("1");
        when(userService.updateUser(c)).thenReturn(c);

        User user = userResource.updateUser(c.getId(), c);
        UserUtils.assertObjects(user, c);
    }

    @Test
    public void testGetAllUsers() {
        List<User> list =
                Arrays.asList(UserUtils.createUser("1"), UserUtils.createUser("2"));
        when(userService.getAllUsers()).thenReturn(list);

        List<User> users = userResource.getAllUsers();
        assertEquals(users.size(), list.size());
    }

    @Test
    public void testDelete() {
        userResource.deleteUser("1");
        verify(userService, times(1)).deleteUser("1");
    }
}
