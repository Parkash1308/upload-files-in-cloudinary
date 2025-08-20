package com.testing.imageuploadtest.dto.req;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserRequest {
    private String name;
    private String email;
    private MultipartFile profilePicFile;
    private MultipartFile resumeFile;
}