package com.example.blogger.users;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

public class UserDTO {
    private UserDTO() {}

    @Data
    public static class CreateUserRequest {
        private String username;
        private String password;
        private String email;
        private String bio;
    }

    @Data
    public static class LoginUserRequest {
        private String username;
        private String password;
    }

    @Data
    public static class LoginUserResponse {
        private Long id;
        private String username;
        private String email;
        private String bio;
        private String token;
    }

    @Data
    public static class GetUserResponse {
        private Long id;
        private String username;
        private String bio;
    }

}
