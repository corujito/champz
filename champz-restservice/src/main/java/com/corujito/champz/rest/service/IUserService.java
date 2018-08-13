package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.User;

public interface IUserService {

    User getUser(String id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(String id);
}
