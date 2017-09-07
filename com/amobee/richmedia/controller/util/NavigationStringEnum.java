package com.amobee.richmedia.controller.util;

public enum NavigationStringEnum {
    NONE("none"),
    CLOSE("close"),
    BACK("back"),
    FORWARD("forward"),
    REFRESH("refresh");
    
    private String text;

    private NavigationStringEnum(String str) {
        this.text = str;
    }

    public static NavigationStringEnum fromString(String str) {
        if (str != null) {
            for (NavigationStringEnum navigationStringEnum : values()) {
                if (str.equalsIgnoreCase(navigationStringEnum.text)) {
                    return navigationStringEnum;
                }
            }
        }
        return null;
    }

    public String getText() {
        return this.text;
    }
}
