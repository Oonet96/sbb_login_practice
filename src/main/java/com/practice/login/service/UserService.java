package com.practice.login.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.login.entity.User;
import com.practice.login.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository _repo;

    public void userSignUp(String id, String pw){

        User tmp = new User(id,getPwHash(pw));

        _repo.save(tmp);
    }

    @Transactional(readOnly = true)
    public boolean userLogin(String id, String pw){
        System.out.println("userid: "+id);
        Optional<User> optTemp = _repo.findByUserId(id);
        
        //if(optTemp.isEmpty()) // -- 일치하는 id가 없을경우

        User tmpData = optTemp.get();
       
        return comparePw(pw,tmpData.getPassword());
        //true일 경우 로그인 성공
        //로그인 성공시 Auth token 생성해서 resDto에 담아서 보낼것!
    }

    @Transactional(readOnly = true)
    public boolean getCheckDuplicateId(String userId){
        return _repo.existsByUserId(userId);
    }


    private String getPwHash(String pw){
        return BCrypt.hashpw(pw, BCrypt.gensalt());
    }

    private boolean comparePw(String pw, String dPw){
        return BCrypt.checkpw(pw, dPw);
    }
}
