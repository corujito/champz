package com.corujito.champz.rest.model;

import java.util.List;

public class ClassificationTable {

    private Group group;
    private List<ClassificationRow> rows;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<ClassificationRow> getRows() {
        return rows;
    }

    public void setRows(List<ClassificationRow> rows) {
        this.rows = rows;
    }

    public ClassificationTable withGroup(Group group) {
        setGroup(group);
        return this;
    }

    public ClassificationTable withRows(List<ClassificationRow> rows) {
        setRows(rows);
        return this;
    }
}
