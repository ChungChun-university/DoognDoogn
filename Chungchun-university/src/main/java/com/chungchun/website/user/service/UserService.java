package com.chungchun.website.user.service;

import com.chungchun.website.user.model.RoleType;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.model.UserDTO;
import com.chungchun.website.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserDTO userDTO) {

        User user = User.builder()
                .userId(userDTO.getUserId())
                .userPwd(passwordEncoder.encode(userDTO.getUserPwd()))
                .userName(userDTO.getUserName())
                .userPhone(userDTO.getUserPhone())
                .role(RoleType.valueOf(userDTO.getRole()))
                .build();

        User savedUser = userRepository.save(user);

        log.info("저장된 사용자 : {}", savedUser.getUserNo());
    }
}
