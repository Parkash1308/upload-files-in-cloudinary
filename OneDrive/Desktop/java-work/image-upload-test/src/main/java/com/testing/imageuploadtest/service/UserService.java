package com.testing.imageuploadtest.service;

import com.testing.imageuploadtest.dto.req.UserRequest;
import com.testing.imageuploadtest.dto.res.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}