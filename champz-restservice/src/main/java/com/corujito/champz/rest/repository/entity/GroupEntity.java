package com.corujito.champz.rest.repository.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groups")
public class GroupEntity extends BaseEntity {

    private int order;
    private String name;
    private List<GroupTeamPresenceEntity> presences;

    private String phaseId;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    public List<GroupTeamPresenceEntity> getPresences() {
        return presences;
    }

    public void setPresences(List<GroupTeamPresenceEntity> presences) {
        this.presences = presences;
    }

    public GroupEntity withId(String id) {
        setId(id);
        return this;
    }

    public GroupEntity withName(String name) {
        setName(name);
        return this;
    }

    public GroupEntity withOrder(int order) {
        setOrder(order);
        return this;
    }

    public GroupEntity withPhaseId(String phaseId) {
        setPhaseId(phaseId);
        return this;
    }

    public GroupEntity withPresences(List<GroupTeamPresenceEntity> presences) {
        setPresences(presences);
        return this;
    }
}
