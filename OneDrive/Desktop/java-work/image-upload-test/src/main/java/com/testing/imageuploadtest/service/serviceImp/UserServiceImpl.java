package com.testing.imageuploadtest.service.serviceImp;

import com.testing.imageuploadtest.dto.req.UserRequest;
import com.testing.imageuploadtest.dto.res.UserResponse;
import com.testing.imageuploadtest.exception.BadRequestException;
import com.testing.imageuploadtest.model.User;
import com.testing.imageuploadtest.repository.UserRepository;
import com.testing.imageuploadtest.service.CloudinaryService;
import com.testing.imageuploadtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // Upload the profile picture and get its URL
        String profilePicUrl = uploadFile(userRequest.getProfilePicFile(), "user_profiles");
        
        // Upload the resume file and get its URL
        String resumeUrl = uploadFile(userRequest.getResumeFile(), "user_resumes");

        // Create the User entity
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setProfilePicUrl(profilePicUrl);
        user.setResumeUrl(resumeUrl); // Save the resume URL
        
        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Map to DTO for response
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setProfilePicUrl(savedUser.getProfilePicUrl());
        userResponse.setResumeUrl(savedUser.getResumeUrl()); // Include resume URL in response

        return userResponse;
    }

    /**
     * Helper method to handle file uploads to Cloudinary.
     * Throws a BadRequestException if the upload fails.
     */
    private String uploadFile(MultipartFile file, String folder) {
        if (file == null || file.isEmpty()) {
            return null;
        }
        try {
            return cloudinaryService.uploadFile(file, folder);
        } catch (IOException e) {
            throw new BadRequestException("Failed to upload " + file.getOriginalFilename() + ".");
        }
    }
}