package com.moon.pinnamon.downloadmanager.controller;

import com.moon.pinnamon.downloadmanager.service.SettingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {

    private final SettingService settingService;

    public SettingController(SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping("/v1/setting/video")
    public String getVideoPath(){
        return settingService.getVideoPath();
    }
}
