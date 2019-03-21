package com.ua.rozetka.isakov.common.issue_tracker;


public enum JiraIssueTypes {
    BUG(1),
    TASK(3),
    IMPROVEMENT(4),
    SUB_TASK(5),
    EPIC(10000),
    E_FEATURE(11200),
    CHANGE_REQUEST(10500)
    ;

    private long typeId;

    JiraIssueTypes(long typeId) {
        this.typeId = typeId;
    }

    public long getTypeId() {
        return typeId;
    }
}
