package com.ua.rozetka.isakov.common.issue_tracker;


public enum JiraFieldSelectValues {
    FIXED_ID_1("\n" +
            "            Fixed\n" +
            "        "),
    WONT_FIX_ID_2("\n" +
            "            Won't Fix\n" +
            "        "),
    DUPLICATE_ID_3("\n" +
            "            Duplicate\n" +
            "        "),
    INCOMPLETE_ID_4("\n"+
            "            Incomplete\n"+
            "        "),
    CANNOT_REPRODUCE_ID_5("\n" +
            "            Cannot Reproduce\n" +
            "        "),
    NOT_A_BUG_ID_10105("\n" +
            "            Not a BUG\n" +
            "        "),
    DONE_ID_10401("\n" +
            "            Done\n" +
            "        ")
    ;

    private String fieldSelectValue;

    JiraFieldSelectValues(String actionName) {
        this.fieldSelectValue = actionName;
    }

    public String getFieldSelectValue() {
        return fieldSelectValue;
    }
}
