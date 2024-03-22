package com.techbytes.security.api.service;

import com.techbytes.security.api.entity.UserInfo;
import com.techbytes.security.api.model.UserInfoUserDetails;
import com.techbytes.security.api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfoUserDetailsService() {
    }
    public UserInfoUserDetailsService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(userName);
       return userInfo.map(UserInfoUserDetails::new)
               .orElseThrow(() -> new UsernameNotFoundException("User not found in db : "+userName));
    }
}
