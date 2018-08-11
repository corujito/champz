package com.corujito.champz.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.repository.IGroupRepository;
import com.corujito.champz.rest.repository.entity.GroupEntity;

@Service
public class GroupServiceImpl implements IGroupService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IGroupRepository repository;

    @Override
    public Group getGroup(String id) {
        Optional<GroupEntity> opt = repository.findById(id);
        return opt.map(c -> modelMapper.map(c, Group.class)).orElse(null);
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        List<GroupEntity> entities = repository.findAll();
        for (GroupEntity entity : entities) {
            groups.add(modelMapper.map(entity, Group.class));
        }
        return groups;
    }

    @Override
    public List<Group> getGroupsByPhaseId(String phaseId) {
        List<Group> groups = new ArrayList<>();
        List<GroupEntity> entities = repository.findByPhaseId(phaseId);
        for (GroupEntity entity : entities) {
            groups.add(modelMapper.map(entity, Group.class));
        }
        return groups;
    }

    @Override
    public Group addGroup(Group group) {
        GroupEntity entity = repository.save(modelMapper.map(group, GroupEntity.class));
        return modelMapper.map(entity, Group.class);
    }

    @Override
    public Group updateGroup(Group group) {
        return addGroup(group);
    }

    @Override
    public void deleteGroup(String id) {
        repository.deleteById(id);
    }
}
