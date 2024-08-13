
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

@CrossOrigin(origins = "*") // 모든 도메인 허용, 필요에 따라 변경
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
        Like like = likeService.addLike(userNo, postNo);
        if (like != null) {
            return ResponseEntity.ok(new LikeResponse(true, like.getCreateDate()));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new LikeResponse(false, null));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<LikeResponse> removeLike(@RequestParam int userNo, @RequestParam int postNo) throws LikeNotFoundException {
        likeService.removeLike(userNo, postNo);
        return ResponseEntity.ok(new LikeResponse(false, null)); // 삭제된 경우
    }

    @GetMapping("/my-likes/{userNo}")
    public ResponseEntity<List<Like>> getMyLikes(@PathVariable int userNo) {
        List<Like> likes = likeService.getLikesByUser(userNo);
        if (likes.isEmpty()) {
            log.warn("No likes found for userNo: {}", userNo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(likes);
        }
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/post/{postNo}")
    public ResponseEntity<Post> getPostDetail(@PathVariable int postNo) {
        Post post = likeService.getPostDetail(postNo);
        return ResponseEntity.ok(post);
    }
}