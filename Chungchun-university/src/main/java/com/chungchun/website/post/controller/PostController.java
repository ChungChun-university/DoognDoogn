package com.chungchun.website.post.controller;

import com.chungchun.website.auth.principal.AuthPrincipal;
import com.chungchun.website.common.ArticlePage;
import com.chungchun.website.common.PagingButtonInfo;
import com.chungchun.website.post.model.Post;
import com.chungchun.website.post.model.PostDTO;
import com.chungchun.website.post.service.PostService;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.model.UserDTO;
import com.chungchun.website.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    private final UserService userService;

    // 전체 게시글 조회
    @GetMapping("/postDetails")
    public String postDetails(Model model, @PageableDefault Pageable pageable){

        Page<PostDTO> postList = postService.findAllPosts(pageable);

        PagingButtonInfo paging = ArticlePage.getPagingButtonInfo(postList);

        model.addAttribute("paging",paging);
        model.addAttribute("postList",postList);

        return "post/postDetails";
    }

    // 내 게시글 조회
    @GetMapping("/myPost")
    public String myPost(@AuthenticationPrincipal UserDetails userDetails, Model model, @PageableDefault Pageable pageable){

        // UserDetails를 AuthPrincipal로 캐스팅
        AuthPrincipal authPrincipal = (AuthPrincipal) userDetails;

        User user = authPrincipal.getUser();

        Page<PostDTO> myPostList = postService.findPostsByUser(user,pageable);

        PagingButtonInfo paging = ArticlePage.getPagingButtonInfo(myPostList);

        model.addAttribute("postList",myPostList);
        model.addAttribute("paging",paging);

        return "post/myPost";
    }

    // 게시글 단일 조회 기능
    @GetMapping("/{postNo}")
    public String findMenuByCode(@PathVariable("postNo") int postNo, Model model) {

        log.info("menuCode = {}", postNo);

        Post post = postService.findByPostNo(postNo);

        model.addAttribute("post",post);

        return "post/readPost";
    }

    // 게시글 작성
    @GetMapping("/createPost")
    public String createPost(){

        log.info("createPost 이동 get 요청 들어옴...");
        return "post/createPost";
    }

    @PostMapping("/createPost")
    public String createPost(@AuthenticationPrincipal UserDetails userDetails, PostDTO postDTO) {

        log.info("createPost Post 요청 확인!");

        // UserDetails를 AuthPrincipal로 캐스팅
        AuthPrincipal authPrincipal = (AuthPrincipal) userDetails;

        String memberId = authPrincipal.getUsername();
        int userNo = authPrincipal.getUserNo();

        // member 찾기
        UserDTO user = userService.findUserById(memberId);

        log.info("로그인한 사용자 ID : {}", memberId);
        log.info("로그인한 사용자 No : {}", userNo);
        log.info("전달받은 PostDTO : {}", postDTO);

        postService.create(postDTO, user);

        return "redirect:/";
    }


}
