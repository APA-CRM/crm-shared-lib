package com.crm.sharedlib.core.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class UserResponse {

    private Long id;

    private String login;

    private String email;

    private String fullName;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String aboutYourself;

    private Instant createdAt;

    private Instant updateAt;

}
