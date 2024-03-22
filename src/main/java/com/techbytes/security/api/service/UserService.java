package com.techbytes.security.api.service;

import com.techbytes.security.api.entity.UserInfo;
import com.techbytes.security.api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo createUser(UserInfo userInfo){
        userInfo.setPassword(userInfo.getPassword());
        return userInfoRepository.save(userInfo);
    }
}
