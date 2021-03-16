package com.moon.pinnamon.downloadmanager.repository;

import com.moon.pinnamon.downloadmanager.model.Video;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface VideoRepository extends R2dbcRepository<Video, Long> {
    Video getVideoByName(String name);
}
