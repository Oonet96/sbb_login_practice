package com.practice.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RequestUser {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserLoginData{
        private String userId;
        private String userPw;
    }
}
