package com.amobee.richmedia.controller.util;

public enum TransitionStringEnum {
    DEFAULT("default"),
    DISSOLVE("dissolve"),
    FADE("fade"),
    ROLL("roll"),
    SLIDE("slide"),
    ZOOM("zoom"),
    NONE("none");
    
    private String text;

    private TransitionStringEnum(String str) {
        this.text = str;
    }

    public static TransitionStringEnum fromString(String str) {
        if (str != null) {
            for (TransitionStringEnum transitionStringEnum : values()) {
                if (str.equalsIgnoreCase(transitionStringEnum.text)) {
                    return transitionStringEnum;
                }
            }
        }
        return null;
    }

    public String getText() {
        return this.text;
    }
}
