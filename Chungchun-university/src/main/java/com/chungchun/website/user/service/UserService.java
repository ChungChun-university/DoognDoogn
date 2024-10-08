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
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 관련해서
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Transactional
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

    /***
     *
     * @param userId
     * @param updateUserDTO
     */
    @Transactional
    public void update(String userId, UserDTO updateUserDTO) {
        // 로그인된 사용자와 정보수정하려는 회원이 일치하는가? 확인필요

        User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));


        // DTO의 정보로 엔티티 업데이트
        foundUser.setUserName(updateUserDTO.getUserName());
        foundUser.setUserPhone(updateUserDTO.getUserPhone());
        // 필요한 다른 필드도 업데이트

        // 수정된 엔티티는 트랜잭션이 종료될 때 자동으로 저장됨
        log.info("Updated user: {}", foundUser);
    }

    @Transactional
    public void delete(int userNo) {

        userRepository.deleteById(userNo);
    }

    public String findUserByUserPhone(String userPhone) {

        log.info("log꽝!");
        User userByUserPhone = userRepository.findUserByUserPhone(userPhone);
        if (userByUserPhone != null) {
            return userByUserPhone.getUserId();
        } else {
            return "아이디를 찾을 수 없습니다.";
        }

    }

    public boolean isIdAvailable(String userId) {
        return userRepository.findByUserId(userId) == null; // ID가 존재하지 않으면 사용 가능
    }


    public String findIdByUser(String userName, String userPhone) {
        // 사용자 정보를 조회하는 메소드 호출
        User user = userRepository.findByUserNameAndUserPhone(userName, userPhone);

        // 사용자 ID 반환
        if (user != null) {
            return user.getUserId(); // ID 반환
        } else {
            return null; // 사용자 찾지 못한 경우
        }
    }
}

