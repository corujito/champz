package com.corujito.champz.rest.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.corujito.champz.rest.service.ICSVImporterService;

@RestController
@RequestMapping("/api/upload")
public class UploadResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadResource.class);

    @Autowired
    ICSVImporterService service;

    @PostMapping
    public void uploadCSV(@RequestParam("file") MultipartFile uploadedFile) {
        LOGGER.debug("Upload csv");
        try {
            service.importCsv(uploadedFile.getInputStream());
        } catch (Exception e) {
            LOGGER.error("Error while uploading csv: {}", e.getMessage());
        }
    }

}
