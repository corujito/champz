package com.corujito.champz.rest.resource;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    IUserService userService;

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable String id) {
        LOGGER.debug("User.getUser {}", id);
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        LOGGER.debug("User.getAllUsers");
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        LOGGER.debug("User.addUser");
        return userService.addUser(user);
    }

    @PutMapping(path = "/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        LOGGER.debug("User.updateUser {}", id);
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable String id) {
        LOGGER.debug("User.deleteUser {}", id);
        userService.deleteUser(id);
    }
}
