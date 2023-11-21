package com.prv.example.demoSB.controller;

import com.prv.example.demoSB.SBProperties;
import com.prv.example.demoSB.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadService service;


    @RequestMapping(
            path = "/",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadImage(@RequestParam("file") final MultipartFile file) {
        return this.service.uploadFile(file);
    }

    @RequestMapping(
            path = "/delete/{fileName}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity deleteFile(@RequestParam("fileName") final String fileName) {
        final boolean fileDeleted = this.service.deleteFile(fileName);
        if(!fileDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            path = "/download/{fileName:.+}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") final String fileName) throws IOException {
        final Resource file = this.service.loadAsResource(fileName);

        if (file == null)
            return ResponseEntity.notFound().build();
        final InputStreamResource resource = new InputStreamResource(file.getInputStream());
        final HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename());
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }

    @GetMapping("/")
    public Set<String> listUploadedFiles() throws IOException {

        return this.service.loadAll();


    }

}
