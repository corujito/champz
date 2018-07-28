package com.corujito.champz.rest.repository.entity;

public class GroupTeamPresenceEntity extends BaseEntity {

    private String groupId;
    private String teamId;
    private int initialPoints;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getInitialPoints() {
        return initialPoints;
    }

    public void setInitialPoints(int initialPoints) {
        this.initialPoints = initialPoints;
    }

    public GroupTeamPresenceEntity withId(String id) {
        setId(id);
        return this;
    }

    public GroupTeamPresenceEntity withGroupId(String groupId) {
        setGroupId(groupId);
        return this;
    }

    public GroupTeamPresenceEntity withTeamId(String teamId) {
        setTeamId(teamId);
        return this;
    }

    public GroupTeamPresenceEntity withInitialPoints(int initialPoints) {
        setInitialPoints(initialPoints);
        return this;
    }
}
