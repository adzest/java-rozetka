package com.ua.rozetka.isakov.common;

public enum ColorsTypes {
    ROSE_GOLD("#FC9"),
    GOLD("#FC9"),
    SPACE_GRAY("#666"),
    SILVER("#CCC"),
    ;
    private String color;

    ColorsTypes(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
