package com.moon.pinnamon.downloadmanager.service;

import com.moon.pinnamon.downloadmanager.model.Video;
import org.springframework.core.io.UrlResource;

public interface MediaStreamingService {
    Video getResourceByName(String name);
    long getLengthOf(UrlResource urlResource);
}
