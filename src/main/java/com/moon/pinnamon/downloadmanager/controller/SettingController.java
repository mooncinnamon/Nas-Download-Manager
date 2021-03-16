package com.moon.pinnamon.downloadmanager.controller;

import com.moon.pinnamon.downloadmanager.service.SettingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SettingController {

    private final SettingService settingService;

    public SettingController(SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping("/v1/setting/video")
    public Mono<String> getVideoPath() {
        String url = settingService.getVideoPath();
        return Mono.just(url);
    }
}
