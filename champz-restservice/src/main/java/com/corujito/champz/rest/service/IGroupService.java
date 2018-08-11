package com.corujito.champz.rest.service;

import java.util.List;
import com.corujito.champz.rest.model.Group;

public interface IGroupService {

    Group getGroup(String id);

    List<Group> getAllGroups();

    List<Group> getGroupsByPhaseId(String phaseId);

    Group addGroup(Group group);

    Group updateGroup(Group group);

    void deleteGroup(String id);
}
