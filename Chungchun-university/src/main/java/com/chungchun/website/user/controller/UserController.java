package com.chungchun.website.user.controller;

import com.chungchun.website.user.model.User;
import com.chungchun.website.user.model.UserDTO;
import com.chungchun.website.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    // 회원가입
    @GetMapping("/register")
    public String register() {return "user/signUp";}

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

        log.info("userDTO : {}",userDTO);

        model.addAttribute("user", userDTO);
        return "user/profile";
    }

    // 자신의 정보 수정 폼
    @GetMapping("/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        String userId = userDetails.getUsername();

        UserDTO userDTO = userService.findUserById(userId);

        log.info("userDTO2 : {}",userDTO);

        model.addAttribute("user", userDTO);
        return "user/edit";
    }

    // 자신의 정보 수정
    @PostMapping("/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails, UserDTO updateUserDTO) {

        // 로그인한 사용자
        String userId = userDetails.getUsername();


        log.info("edit user : {}", userId);
        userService.update(userId,updateUserDTO);
        return "redirect:/user/profile"; // 수정 후 프로필 페이지로 리다이렉트
    }

    // 자신의 정보 삭제
    @PostMapping("/delete")
    public String delete(@AuthenticationPrincipal UserDetails userDetails) {

        String userId = userDetails.getUsername();

        UserDTO userDTO = userService.findUserById(userId);

        log.info("delete user : {}", userDTO);
        userService.delete(userDTO.getUserNo()); // 사용자 ID를 기반으로 삭제


        return "redirect:/"; // 삭제 후 로그인 페이지로 리다이렉트
    }
}
