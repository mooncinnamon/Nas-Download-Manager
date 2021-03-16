package com.moon.pinnamon.downloadmanager.service;

import com.moon.pinnamon.downloadmanager.model.Video;
import com.moon.pinnamon.downloadmanager.repository.VideoRepository;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class MediaStreamingServiceImpl implements MediaStreamingService {

    private final VideoRepository videoRepository;

    public MediaStreamingServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video getResourceByName(String name) {
        return null;
    }

    @Override
    public long getLengthOf(UrlResource urlResource) {
        return 0;
    }
}
