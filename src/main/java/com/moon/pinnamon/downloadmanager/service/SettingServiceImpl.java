package com.moon.pinnamon.downloadmanager.service;

import com.moon.pinnamon.downloadmanager.repository.ConfigRepository;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService{

    private final ConfigRepository configRepository;

    public SettingServiceImpl(ConfigRepository configRepository){
        this.configRepository = configRepository;
    }

    @Override
    public String getVideoPath() {
        return configRepository.getConfigByType("video").getUrl();
    }
}
