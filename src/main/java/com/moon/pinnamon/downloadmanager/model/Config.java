package com.moon.pinnamon.downloadmanager.model;

import com.moon.pinnamon.downloadmanager.model.enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config {
    private int seq;
    private MediaType type;
    private String url;
}
