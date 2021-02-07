package com.moon.pinnamon.downloadmanager.controller;

import com.moon.pinnamon.downloadmanager.service.FileDownloadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FileDownloadController {

    private final FileDownloadService fileDownloadService;

    public FileDownloadController(FileDownloadService fileDownloadService) {
        this.fileDownloadService = fileDownloadService;
    }

    @GetMapping("/file-download")
    public Mono<Boolean> fileDownload(String url) {
        boolean isImageDownload = fileDownloadService.imageDownload(url);
        return Mono.just(isImageDownload);
    }
}
