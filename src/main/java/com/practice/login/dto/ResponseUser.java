package com.practice.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ResponseUser {


    @Getter
    @AllArgsConstructor
    public static class CheckDuplicateIDResult{
        private boolean bDuplicate;
        private String message;
    }
}
