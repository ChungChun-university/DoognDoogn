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
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Like addLike(User user, Post post) {
        // 이미 좋아요가 등록되어 있는지 확인
        if (likeRepository.existsByUserAndPost(user, post)) {
            return null; // 이미 좋아요가 등록되어 있는 경우
        }

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        like.setCreateDate(LocalDate.from(LocalDateTime.now()));
        likeRepository.save(like);

        // 게시글의 좋아요 카운터 증가
        int currentLikeCount = post.getLikeCount() != null ? post.getLikeCount() : 0; // null 체크
        post.setLikeCount(currentLikeCount + 1);
        postRepository.save(post);

        return like;
    }

    public void removeLike(User user, Post post) throws LikeNotFoundException {
        // 좋아요 찾기
        Like like = likeRepository.findByUserAndPost(user, post)
                .orElseThrow(() -> new RuntimeException("좋아요가 존재하지 않습니다."));

        likeRepository.delete(like); // 좋아요 삭제

        // 게시글의 좋아요 카운터 감소
        post.setLikeCount(post.getLikeCount() - 1);
        postRepository.save(post);
    }

    public List<Like> getLikesByUser(int userNo) {
        // userNo로 User 객체를 가져옵니다.
        User user = userRepository.findById(userNo)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // User 객체를 사용하여 Like 목록을 가져옵니다.
        return likeRepository.findByUser(user);
    }

    // 또는 userNo로 직접 좋아요 목록을 가져오려면
    public List<Like> getLikesByUserNo(int userNo) {
        return likeRepository.findByUser_UserNo(userNo); // User의 userNo를 사용
    }

    @Transactional
    public void deleteLike(int userNo, int postNo) {
        likeRepository.deleteByUser_UserNoAndPost_PostNo(userNo, postNo);
    }
}

