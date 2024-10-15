package com.practice.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.login.dto.RequestUser;
import com.practice.login.dto.ResponseUser;
import com.practice.login.service.UserService;

import lombok.RequiredArgsConstructor;


//POST - user/signup
//GET - /user/login
//POST - /user/login

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService _service;

    //회원가입 - 임시로 UserLoginData dto 사용 추후 추가될 유저 정보가 나오면 바꿀것
    @PostMapping("signup")
    public void POSTUserSignUp(@RequestBody RequestUser.UserLoginData data){
        _service.userSignUp(data.getUserId(),data.getUserPw());
    }

    //아이디 중복 체크
    @GetMapping("duplicate")
    public ResponseUser.CheckDuplicateIDResult GETCheckDuplicateId(String userId){
        return new ResponseUser.CheckDuplicateIDResult(_service.getCheckDuplicateId(userId), "message");
    }

    //로그인
    @PostMapping("login")
    public boolean POSTUserLogin(@RequestBody RequestUser.UserLoginData data){
       return _service.userLogin(data.getUserId(),data.getUserPw());
    }

}
