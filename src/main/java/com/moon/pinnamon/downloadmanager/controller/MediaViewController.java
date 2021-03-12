package com.moon.pinnamon.downloadmanager.controller;

import com.moon.pinnamon.downloadmanager.service.MediaStreamingService;
import org.springframework.core.io.UrlResource;
import org.springframework.http.CacheControl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
public class MediaViewController {

    private final MediaStreamingService mediaStreamingService;

    public MediaViewController(MediaStreamingService mediaStreamingService) {
        this.mediaStreamingService = mediaStreamingService;
    }


    @GetMapping("/video/{name}")
    public Mono<ServerResponse> getVideoStreaming(@PathVariable String name) {
        UrlResource videoResourceMono = mediaStreamingService.getResourceByName(name);

        return Mono.just(videoResourceMono).flatMap(urlResource -> {
            long contentLength = mediaStreamingService.getLengthOf(urlResource);
            return ServerResponse
                    .ok()
                    .contentLength(contentLength)
                    .headers(httpHeaders -> httpHeaders.setCacheControl(CacheControl.noCache()))
                    .body(videoResourceMono, UrlResource.class);
        });
    }
}
