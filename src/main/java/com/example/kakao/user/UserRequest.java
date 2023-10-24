package com.example.kakao.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class UserRequest {
    @Getter
    @Setter
    @ToString
    public static class JoinDTO {
        
        @NotEmpty()
        private String email;

        @NotEmpty()
        @Size(min = 4, max = 20, message = "4에서 20자 이내여야 합니다.")
        private String password;


        public User toEntity() {
            return User.builder()
                    .email(email)
                    .password(password)
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class LoginDTO {
        @NotEmpty        
        private String email;
        @NotEmpty
        private String password;
    }
}
