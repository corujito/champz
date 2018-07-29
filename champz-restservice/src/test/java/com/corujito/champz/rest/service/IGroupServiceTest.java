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
import com.corujito.champz.rest.GroupUtils;
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.repository.IGroupRepository;
import com.corujito.champz.rest.repository.entity.GroupEntity;

@RunWith(MockitoJUnitRunner.class)
public class IGroupServiceTest {

    @InjectMocks
    @Autowired
    GroupServiceImpl groupService;

    @Mock
    IGroupRepository repository;

    @Test
    public void testGetGroup() throws Exception {
        Optional<GroupEntity> x = Optional.of(GroupUtils.createGroupEntity("1"));
        when(repository.findById("1")).thenReturn(x);

        Group group = groupService.getGroup("1");
        GroupUtils.assertObjects(x.get(), group);
    }

    @Test
    public void testAddGroup() {
        GroupEntity c = GroupUtils.createGroupEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Group group = groupService.addGroup(new Group());
        GroupUtils.assertObjects(c, group);
    }

    @Test
    public void testUpdateGroup() {
        GroupEntity c = GroupUtils.createGroupEntity("1");
        when(repository.save(Mockito.any())).thenReturn(c);

        Group group = groupService.updateGroup(new Group());
        GroupUtils.assertObjects(c, group);
    }

    @Test
    public void testGetAllGroups() {
        List<GroupEntity> entities = Arrays.asList(GroupUtils.createGroupEntity("1"),
                GroupUtils.createGroupEntity("2"));
        when(repository.findAll()).thenReturn(entities);

        List<Group> groups = groupService.getAllGroups();
        assertEquals(groups.size(), entities.size());
    }

    @Test
    public void testDelete() {
        groupService.deleteGroup("1");
        verify(repository, times(1)).deleteById("1");
    }
}
