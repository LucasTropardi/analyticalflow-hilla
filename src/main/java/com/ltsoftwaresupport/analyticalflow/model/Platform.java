package com.ltsoftwaresupport.analyticalflow.model;

import lombok.Getter;

public enum Platform {
    XBOX("Xbox"),
    PLAYSTATION("Playstation"),
    SWITCH("Nintendo Swtich"),
    PC("PC"),
    MOBILE("Mobile");

    @Getter
    private String platform;

    Platform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return this.platform;
    }
}
