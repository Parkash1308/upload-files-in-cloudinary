package com.testing.imageuploadtest.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public String uploadFile(MultipartFile file, String folderName) throws IOException {
        try {
            // Use 'auto' to let Cloudinary automatically detect the file type
            Map<String, Object> uploadResult = cloudinary.uploader().upload(
                file.getBytes(), 
                ObjectUtils.asMap(
                    "folder", folderName,
                    "resource_type", "auto" // This is the key change to handle PDFs
                )
            );
            return uploadResult.get("url").toString();
        } catch (IOException e) {
            throw new IOException("Failed to upload file to Cloudinary.", e);
        }
    }
}