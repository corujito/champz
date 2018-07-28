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
import com.corujito.champz.rest.model.Group;
import com.corujito.champz.rest.service.IGroupService;

@RestController
@RequestMapping("/api/groups")
public class GroupResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupResource.class);

    @Autowired
    IGroupService groupService;

    @GetMapping(path = "/{id}")
    public Group getGroup(@PathVariable String id) {
        LOGGER.debug("Group.getGroup {}", id);
        return groupService.getGroup(id);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        LOGGER.debug("Group.getAllGroups");
        return groupService.getAllGroups();
    }

    @PostMapping
    public Group addGroup(@RequestBody Group group) {
        LOGGER.debug("Group.addGroup");
        return groupService.addGroup(group);
    }

    @PutMapping(path = "/{id}")
    public Group updateGroup(@PathVariable String id, @RequestBody Group group) {
        LOGGER.debug("Group.updateGroup {}", id);
        return groupService.updateGroup(group);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteGroup(@PathVariable String id) {
        LOGGER.debug("Group.deleteGroup {}", id);
        groupService.deleteGroup(id);
    }

}
