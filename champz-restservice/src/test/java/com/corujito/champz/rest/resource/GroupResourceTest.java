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
import com.corujito.champz.rest.GroupUtils;
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.service.IGroupService;

@RunWith(MockitoJUnitRunner.class)
public class GroupResourceTest {

    @InjectMocks
    @Autowired
    GroupResource groupResource;

    @Mock
    IGroupService groupService;

    @Before
    public void before() {}

    @Test
    public void testGetGroup() throws Exception {
        Group c = GroupUtils.createGroup("1");
        when(groupService.getGroup("1")).thenReturn(c);

        Group group = groupResource.getGroup("1");
        GroupUtils.assertObjects(group, c);
    }

    @Test
    public void testAddGroup() {
        Group c = GroupUtils.createGroup("1");
        when(groupService.addGroup(c)).thenReturn(c);

        Group group = groupResource.addGroup(c);
        GroupUtils.assertObjects(group, c);
    }

    @Test
    public void testUpdateGroup() {
        Group c = GroupUtils.createGroup("1");
        when(groupService.updateGroup(c)).thenReturn(c);

        Group group = groupResource.updateGroup(c.getId(), c);
        GroupUtils.assertObjects(group, c);
    }

    @Test
    public void testGetAllGroups() {
        List<Group> list =
                Arrays.asList(GroupUtils.createGroup("1"), GroupUtils.createGroup("2"));
        when(groupService.getAllGroups()).thenReturn(list);

        List<Group> groups = groupResource.getAllGroups();
        assertEquals(groups.size(), list.size());
    }

    @Test
    public void testDelete() {
        groupResource.deleteGroup("1");
        verify(groupService, times(1)).deleteGroup("1");
    }
}
