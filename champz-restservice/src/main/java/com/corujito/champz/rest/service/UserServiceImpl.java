package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.User;
import com.corujito.champz.rest.repository.IUserRepository;
import com.corujito.champz.rest.repository.entity.UserEntity;

@Service
public class UserServiceImpl implements IUserService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IUserRepository repository;

    @Override
    public User getUser(String id) {
        Optional<UserEntity> opt = repository.findById(id);
        return opt.map(u -> modelMapper.map(u, User.class)).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<UserEntity> opt = repository.findByEmail(email);
        return opt.map(u -> modelMapper.map(u, User.class)).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        List<UserEntity> entities = repository.findAll();
        for (UserEntity entity : entities) {
            users.add(modelMapper.map(entity, User.class));
        }
        return users;
    }

    @Override
    public User addUser(User user) {
        UserEntity entity = repository.save(modelMapper.map(user, UserEntity.class));
        return modelMapper.map(entity, User.class);
    }

    @Override
    public User updateUser(User user) {
        return addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
