package com.ua.rozetka.isakov.common.issue_tracker;


public enum JiraFlowActions {
    START_PROGRESS("Start Progress"),
    START_DEV("Start Dev"),
    CODE_REVIEW("Code Review"),
    RESOLVE("Resolve"),
    READY_FOR_QA("Ready for QA"),
    START_QA("Start QA"),
    VERIFY("Verify"),
    CLOSE("Close"),
    REOPEN("Reopen")
    ;

    private String actionName;

    JiraFlowActions(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }
}
