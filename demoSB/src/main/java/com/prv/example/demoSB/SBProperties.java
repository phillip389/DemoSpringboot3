package com.prv.example.demoSB;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class SBProperties {

    @Value("${multipart.location}")
    private String uploadLocation = "";

    public String getUploadLocation() {
        return this.uploadLocation;
    }

}
