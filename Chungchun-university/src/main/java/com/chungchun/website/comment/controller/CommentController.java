package com.chungchun.website.comment.controller;

import com.chungchun.website.auth.principal.AuthPrincipal;
import com.chungchun.website.comment.model.AddCommentRequest;
import com.chungchun.website.comment.model.Comment;
import com.chungchun.website.comment.model.CommentDTO;
import com.chungchun.website.comment.service.CommentService;
import com.chungchun.website.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;


    //1. 내 댓글 조회-> 리스트 받아오기
    @GetMapping("/myComment")
    public String myComment(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        log.info("요청로그");

        AuthPrincipal authPrincipal = (AuthPrincipal) userDetails;

        User user = authPrincipal.getUser();
        log.info("userId: {} ", user.getUserId());

        List<Comment> commentList= commentService.findAllByUser(user);

        log.info("commentList: {}", commentList);

        model.addAttribute("commentList", commentList);
        return "comment/myCommentView";
    }
    //2. 내 댓글 작성

    //3. 내 댓글 수정

    //4. 삭제
}
