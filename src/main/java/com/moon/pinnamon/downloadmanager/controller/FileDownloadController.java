package com.moon.pinnamon.downloadmanager.controller;

import com.moon.pinnamon.downloadmanager.model.FileDownloadDto;
import com.moon.pinnamon.downloadmanager.service.FileDownloadService;
import lombok.var;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class FileDownloadController {

    private final FileDownloadService fileDownloadService;

    public FileDownloadController(FileDownloadService fileDownloadService) {
        this.fileDownloadService = fileDownloadService;
    }

    @GetMapping(value = "/file-download")
    public Mono<Boolean> fileDownload(String url) {
        fileDownloadService.imageDownload(url);

        return Mono.just(true);
    }

    @GetMapping(value = "/file-download-progress" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<FileDownloadDto> fileDownloadProgress(String seqNo) {
        return Flux.interval(Duration.ofMillis(500))
                .map(it -> new FileDownloadDto(fileDownloadService.getCurrentProgress()));
    }

}
