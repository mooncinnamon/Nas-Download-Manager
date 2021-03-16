package com.moon.pinnamon.downloadmanager.model.enums;

import lombok.Getter;

@Getter
public enum MediaType {
    Video("video");

    private final String type;

    MediaType(String type) {
        this.type = type;
    }
}
