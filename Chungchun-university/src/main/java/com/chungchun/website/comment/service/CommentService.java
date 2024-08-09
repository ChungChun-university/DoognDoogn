package com.chungchun.website.comment.service;

import com.chungchun.website.comment.model.AddCommentRequest;
import com.chungchun.website.comment.model.Comment;
import com.chungchun.website.comment.model.CommentDTO;
import com.chungchun.website.comment.repository.CommentRepository;
import com.chungchun.website.myclass.model.MyClass;
import com.chungchun.website.post.model.Post;
import com.chungchun.website.post.repository.PostRepository;
import com.chungchun.website.user.model.RoleType;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional( readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> findAllByUser(User user) {
            log.info("log 찍기");
            List<Comment> myCommentList = commentRepository.findAllByUser(user);
            log.info("불러왔어용");
            return myCommentList;
        }

    public Comment save(int userNo, AddCommentRequest request, String userName) {
        Optional<User> userOptional = userRepository.findByUserNo(userNo);
        User user;
        if (userOptional.isPresent()) { // Optional이 값으로 채워져 있는지 확인
            user = userOptional.get(); // User 객체 추출
        } else {
            System.out.println("사용자가 존재하지 않습니다: " + userName);
            return null;
        }
        Post post = (Post) postRepository.findByUserNo(userNo).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다. " + userNo));

        request.setUser(user);
        request.setPost(post);

        return commentRepository.save(request.toEntity());
    }

}