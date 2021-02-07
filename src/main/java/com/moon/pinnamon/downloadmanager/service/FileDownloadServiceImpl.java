package com.moon.pinnamon.downloadmanager.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    @Override
    public boolean imageDownload(String fileUrl) {
        String fileName = "Test.jpg";
        try(InputStream in = new URL(fileUrl).openStream()){
            Path imagePath = Paths.get(fileName);
            Files.copy(in, imagePath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
