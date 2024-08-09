package com.chungchun.website.user.controller;

import com.chungchun.website.user.model.UserDTO;
import com.chungchun.website.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private final UserService userService;

    // 회원가입
    @GetMapping("/register")
    public String register() {
        return "user/signUp";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO) {

        log.info("signup : {}", userDTO);

        userService.register(userDTO);
        return "/auth/login";
    }


    // 자신의 정보 조회
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        String userId = userDetails.getUsername();
        log.info("❤ userId : {}", userId);

        UserDTO userDTO = userService.findUserById(userId);

        log.info("userDTO : {}", userDTO);

        model.addAttribute("user", userDTO);
        return "user/profile";
    }

    // 자신의 정보 수정 폼
    @GetMapping("/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        String userId = userDetails.getUsername();

        UserDTO userDTO = userService.findUserById(userId);

        log.info("userDTO2 : {}", userDTO);

        model.addAttribute("user", userDTO);
        return "user/edit";
    }

    // 자신의 정보 수정
    @PostMapping("/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails, UserDTO updateUserDTO) {

        // 로그인한 사용자
        String userId = userDetails.getUsername();


        log.info("edit user : {}", userId);
        userService.update(userId, updateUserDTO);
        return "redirect:/user/profile"; // 수정 후 프로필 페이지로 리다이렉트
    }

    // 자신의 정보 삭제
    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity<?> delete(@AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request, HttpServletResponse response) {

        String userId = userDetails.getUsername();

        UserDTO userDTO = userService.findUserById(userId);

        log.info("delete user : {}", userDTO);
        userService.delete(userDTO.getUserNo()); // 사용자 ID를 기반으로 삭제

        // 로그아웃 처리
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, null);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/")) // 로그아웃 후 리다이렉트할 URL
                .build();
    }

    // 아이디 찾기
    @GetMapping("/search")
    public String queryIdPage() {
        log.info("log찍힘");
        return "user/queryId";
    }

    @PostMapping("/search")
    public String findUserByUserPhone(@RequestParam String userPhone, Model model) {
        log.info("userPhone =============== {}", userPhone);
        String userId=userService.findUserByUserPhone(userPhone);

        model.addAttribute("userId", userId );
        return "user/searchResult";
//        log.info("userName = {}, userPhone = {}", userName, userPhone);

//        String userId = userService.findIdByNameAndPhone(userName, userPhone);
//        Map<String, Object> response = new HashMap<>();
//
//        if (userId != null) {
//            response.put("userId", userId);
//            return ResponseEntity.ok(response); // ID를 찾았을 경우
//        } else {
//            response.put("error", "일치하는 ID를 찾을 수 없습니다.");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // ID를 찾지 못했을 경우
//        }
    }

    // 아이디 중복 확인
    @PostMapping("/check-id")
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> checkId(@RequestBody String userId) {
        log.info("💟 check-id 요청들어옴 ... userId : {}", userId);
        boolean isAvailable = userService.isIdAvailable(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("available", isAvailable);
        return ResponseEntity.ok(response); // JSON 형식으로 반환
    }
}
