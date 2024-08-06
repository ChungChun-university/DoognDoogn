package com.chungchun.website.user.service;

import com.chungchun.website.user.model.RoleType;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.model.UserDTO;
import com.chungchun.website.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void register(UserDTO userDTO) {

        User user = User.builder()
                .userId(userDTO.getUserId())
                .userPwd(passwordEncoder.encode(userDTO.getUserPwd()))
                .userName(userDTO.getUserName())
                .userPhone(userDTO.getUserPhone())
                .role(RoleType.ROLE_USER)
                .build();

        User savedUser = userRepository.save(user);

        log.info("저장된 사용자 : {}", savedUser.getUserNo());
    }

    public UserDTO findUserById(String userId) {

        User user = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("회원을 찾을 수 없습니다."));


        return modelMapper.map(user, UserDTO.class);
    }

    public void update(UserDTO userDTO, UserDTO updateUserDTO) {
        // 사용자 정보를 데이터베이스에서 조회
        User foundUser = userRepository.findByUserNo(userDTO.getUserNo())
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        // DTO의 정보로 엔티티 업데이트
        foundUser.setUserId(updateUserDTO.getUserId());
        foundUser.setUserName(updateUserDTO.getUserName());
        foundUser.setUserPhone(updateUserDTO.getUserPhone());
        // 필요한 다른 필드도 업데이트

        // 수정된 엔티티는 트랜잭션이 종료될 때 자동으로 저장됨
        log.info("Updated user: {}", foundUser);
    }


    public void delete(int userNo) {

        userRepository.deleteById(userNo);
    }
}
