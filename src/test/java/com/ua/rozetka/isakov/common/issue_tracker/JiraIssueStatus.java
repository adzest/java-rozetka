package com.ua.rozetka.isakov.common.issue_tracker;


public enum JiraIssueStatus {
    OPEN("OPEN"),
    REOPENED("REOPENED"),
    IN_PROGRESS("IN PROGRESS"),
    RESOLVED("RESOLVED"),
    IN_REVIEW("IN REVIEW"),
    READY_FOR_QA("READY for QA"),
    QA_IN_PROGRESS("QA IN PROGRESS"),
    VERIFIED("VERIFIED"),
    CLOSED("CLOSED")
    ;

    private String statusName;

    JiraIssueStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
