package com.moon.pinnamon.downloadmanager.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {


    private long downloadedFileSize = 0;
    private int currentProgress;

    private final String extRegex = ".(zip|jpg)$";

    @Override
    public boolean imageDownload(String fileUrl) {

        Pattern pattern = Pattern.compile(extRegex);
        Matcher matcher = pattern.matcher(fileUrl);
        if (matcher.find()) {
            download(fileUrl, "test1234", matcher.group());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getCurrentProgress() {
        return currentProgress;
    }


    private void download(String strUrl, String fileName, String fileOffset) {
        int fileReadByte = 0;
        try {
            URL url = new URL(strUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());

            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName + fileOffset);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
            byte[] data = new byte[1024];

            while ((fileReadByte = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += fileReadByte;
                currentProgress = (int) ((((double) downloadedFileSize) / ((double) completeFileSize)) * 100000d);
                bufferedOutputStream.write(data, 0, fileReadByte);
            }
            bufferedOutputStream.close();
            in.close();
        } catch (IOException ignored) {
        } finally {
            currentProgress = 0;
            downloadedFileSize = 0;
        }
    }
}
