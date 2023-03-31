package com.itvitae.swdn.service;

import com.itvitae.swdn.model.DBFile;
import com.itvitae.swdn.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {
    @Autowired
    DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Check if the file's name contains invalid characters
        if (fileName.contains("..")) {
            throw new IllegalArgumentException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

        return dbFileRepository.save(dbFile);
    }
}
