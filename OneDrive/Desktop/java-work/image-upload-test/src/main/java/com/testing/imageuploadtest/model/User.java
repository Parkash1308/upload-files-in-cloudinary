package com.testing.imageuploadtest.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "profile_pic_url")
    private String profilePicUrl;

    @Column(name = "resumeUrl")
    private String resumeUrl;
}