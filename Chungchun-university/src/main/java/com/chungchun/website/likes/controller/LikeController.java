
package com.chungchun.website.likes.controller;
import com.chungchun.website.likes.exception.LikeNotFoundException;
import com.chungchun.website.likes.model.Like;
import com.chungchun.website.likes.response.LikeResponse;
import com.chungchun.website.likes.service.LikeService;
import com.chungchun.website.post.model.Post;
import com.chungchun.website.post.repository.PostRepository;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
@Slf4j
public class LikeController {

    private final LikeService likeService;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @PostMapping("/add")
    public ResponseEntity<LikeResponse> addLike(@RequestParam int userNo, @RequestParam int postNo) {
        // 사용자 조회
        User user = userRepository.findById(userNo)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // 게시글 조회
        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        Like like = likeService.addLike(user, post);
        if (like != null) {
            LikeResponse response = new LikeResponse(true, like.getCreateDate());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new LikeResponse(false, null));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<LikeResponse> removeLike(@RequestParam int userNo, @RequestParam int postNo) throws LikeNotFoundException {
        User user = userRepository.findById(userNo)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        likeService.removeLike(user, post);
        LikeResponse response = new LikeResponse(false, null); // 삭제된 경우
        return ResponseEntity.ok(response);
    }

    @GetMapping("/my-likes/{userNo}")
    public ResponseEntity<List<Like>> getMyLikes(@PathVariable int userNo) {
        List<Like> likes = likeService.getLikesByUser(userNo);
        if (likes.isEmpty()) {
            log.warn("No likes found for userNo: {}", userNo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(likes); // 비어있는 경우 204 반환
        }
        return ResponseEntity.ok(likes);
    }
}