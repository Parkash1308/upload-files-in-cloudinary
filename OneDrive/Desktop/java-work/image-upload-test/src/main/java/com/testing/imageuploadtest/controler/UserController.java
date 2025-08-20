package com.testing.imageuploadtest.controler;

import com.testing.imageuploadtest.dto.req.UserRequest;
import com.testing.imageuploadtest.dto.res.UserResponse;
import com.testing.imageuploadtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@ModelAttribute UserRequest userRequest) {
        UserResponse newUser = userService.createUser(userRequest);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}