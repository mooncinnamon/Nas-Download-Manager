package com.moon.pinnamon.downloadmanager.service;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public interface MediaStreamingService {
    UrlResource getResourceByName(String name);
    long getLengthOf(UrlResource urlResource);
}
