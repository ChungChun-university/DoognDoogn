package com.chungchun.website.likes.service;

import com.chungchun.website.likes.exception.LikeNotFoundException;
import com.chungchun.website.likes.model.Like;
import com.chungchun.website.likes.repository.LikeRepository;
import com.chungchun.website.post.model.Post;
import com.chungchun.website.post.repository.PostRepository;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {

    private static final Logger log = LoggerFactory.getLogger(LikeService.class); // 수정
    @Autowired
    private LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public boolean removeLike(int userNo, int postNo) {
        log.info("삭제 요청: userNo={}, postNo={}", userNo, postNo);
        int deletedCount = likeRepository.deleteByUser_UserNoAndPost_PostNo(userNo, postNo);
        log.info("삭제된 좋아요 수: {}", deletedCount);
        return deletedCount > 0;
    }

    public Like addLike(int userNo, int postNo) {
        User user = userRepository.findById(userNo)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        if (likeRepository.existsByUserAndPost(user, post)) {
            return null; // 이미 좋아요가 등록되어 있는 경우
        }

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        like.setCreateDate(LocalDate.from(LocalDateTime.now()));
        likeRepository.save(like);

        post.setLikeCount((post.getLikeCount() != null ? post.getLikeCount() : 0) + 1);
        postRepository.save(post);

        return like;
    }

//    public void removeLike(int userNo, int postNo) {
//        User user = userRepository.findById(userNo)
//                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
//        Post post = postRepository.findById(postNo)
//                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
//
//        Like like = likeRepository.findByUserAndPost(user, post)
//                .orElseThrow(() -> new RuntimeException("좋아요가 존재하지 않습니다."));
//
//        likeRepository.delete(like);
//        post.setLikeCount(post.getLikeCount() != null ? post.getLikeCount() - 1 : 0);
//        postRepository.save(post);
//    }

    public List<Like> getLikesByUser(int userNo) {
        User user = userRepository.findById(userNo)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        return likeRepository.findByUser(user);
    }

    public Post getPostDetail(int postNo) {
        return postRepository.findById(postNo)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }
}

