package com.chungchun.website.comment.service;

import com.chungchun.website.comment.model.Comment;
import com.chungchun.website.comment.repository.CommentRepository;
import com.chungchun.website.post.repository.PostRepository;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


}