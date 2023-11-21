package com.prv.example.demoSB.services;

import com.prv.example.demoSB.SBProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UploadService {


    private SBProperties properties;

    private final Path baseLocation;

    @Autowired
    private UploadService(final SBProperties properties) throws IOException {
        this.properties = properties;

        this.baseLocation = Paths.get(this.properties.getUploadLocation() + "/");
        //Files.createDirectory(this.baseLocation);
    }

    public String uploadFile(final MultipartFile file ) {
        final StringBuilder result = new StringBuilder();
        result.append("File Name: " + file.getOriginalFilename());
        result.append(" Size: " + file.getContentType());
        try {


            final InputStream inputStream = file.getInputStream();

            final byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            File targetFile = new File(this.baseLocation + "/" + file.getOriginalFilename());

            try (final OutputStream outStream = new FileOutputStream(targetFile)) {
                outStream.write(buffer);
            }

            Files.copy(inputStream, this.baseLocation,
                    StandardCopyOption.REPLACE_EXISTING);
            return result.toString();
        } catch (final IOException ie) {
            System.out.println("Error occurred " + ie.getMessage());
            return "";
        }
    }

    public boolean deleteFile(final String filename) {
        try {
            final Path file = this.load(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    private Path load(final String fileName) {
        return baseLocation.resolve(fileName);
    }

    public Resource loadAsResource(final String fileName) {
        try {
            final Path file = this.load(fileName);
            final Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException(
                        "Could not read file: " + fileName);

            }
        } catch (MalformedURLException | FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }

    public Set<String> loadAll() {
        try {
            return Stream.of(new File(this.properties.getUploadLocation()).listFiles())
                    .filter(file -> !file.isDirectory())
                    .map(File::getName)
                    .collect(Collectors.toSet());
        }
        catch (Exception e) {
            System.out.println("IOException " + e.getMessage());
            return null;
        }

    }

}


