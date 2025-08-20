package com.testing.imageuploadtest.dto.res;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String profilePicUrl;
    private String resumeUrl; // Add this new field
}