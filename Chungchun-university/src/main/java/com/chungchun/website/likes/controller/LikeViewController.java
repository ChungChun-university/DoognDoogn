package com.chungchun.website.likes.controller;

import com.chungchun.website.auth.principal.AuthPrincipal;
import com.chungchun.website.likes.model.Like;
import com.chungchun.website.likes.service.LikeService;
import com.chungchun.website.user.model.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/likes")
@RequiredArgsConstructor
@Slf4j
public class LikeViewController {
    private final LikeService likeService;

    @GetMapping("/my-likes/my")
    public String getMyLikes(@AuthenticationPrincipal AuthPrincipal authPrincipal, HttpSession session, Model model) {
        // AuthPrincipal에서 User 객체 가져오기
        User user = authPrincipal.getUser(); // User 객체 가져오기
        // userNo 가져오기
        int userNo = user.getUserNo(); // User 객체에서 사용자 ID 가져오기
        session.setAttribute("userNo", user.getUserNo()); // 사용자 ID를 세션에 저장

        log.info("likes/my-likes/ : 요청들어옴 : {}", userNo);
        List<Like> likes = likeService.getLikesByUser(userNo);
        model.addAttribute("likes", likes);
        return "like/my-likes"; // Thymeleaf 템플릿 이름
    }
}
