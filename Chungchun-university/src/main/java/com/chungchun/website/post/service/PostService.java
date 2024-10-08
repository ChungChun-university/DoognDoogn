package com.chungchun.website.post.service;

import com.chungchun.website.comment.repository.CommentRepository;
import com.chungchun.website.post.model.Post;
import com.chungchun.website.post.model.PostDTO;
import com.chungchun.website.post.repository.PostRepository;
import com.chungchun.website.user.model.User;
import com.chungchun.website.user.model.UserDTO;
import com.chungchun.website.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;


    // 전체 게시글 조회
    public Page<PostDTO> findAllPosts(Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("postNo").descending());

        Page<Post> foundAllPosts = postRepository.findAll(pageable);
        log.info("게시글 수: {}", foundAllPosts.getTotalElements());

        return foundAllPosts.map(post -> modelMapper.map(post, PostDTO.class));
    }

    // 카테고리 필터링 후 게시글 조회
    public Page<PostDTO> findPostsByCategory(String categoryCode, Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("postNo").descending());

        Page<Post> foundPosts = postRepository.findByCategoryCode(categoryCode, pageable);

        return foundPosts.map(post -> modelMapper.map(post, PostDTO.class));
    }

    // 게시글 번호로 조회
    public Post findByPostNo(int postNo) {

        Post post = postRepository.findByPostNo(postNo);

        return post;
    }

    // 내 게시글 조회
    public Page<PostDTO> findPostsByUser(User user, Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("postNo").descending());

        Page<Post> myPost = postRepository.findPostsByUserNo(user, pageable);

        return myPost.map(post -> modelMapper.map(post, PostDTO.class));
    }


    // 게시글 작성
    @Transactional
    public void create(PostDTO postDTO, UserDTO user) {

        String userId = user.getUserId();

        User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("회원을 찾을 수 없습니다."));

        Post post = Post.builder()
                .categoryCode(postDTO.getCategoryCode())
                .clsNo(postDTO.getClsNo())
                .postTitle(postDTO.getPostTitle())
                .postContent(postDTO.getPostContent())
                .postCreateDate(new Date())
                .userNo(foundUser)
                .build();

        Post newPost = postRepository.save(post);

        log.info("등록된 게시글 : {}", newPost);

    }


    @Transactional
    public void deletePost(int postNo) {

        postRepository.deleteById(postNo);
    }

    @Transactional
    public void updatePost(int postNo, String postTitle, String postContent) {

        Post post = postRepository.findById(postNo)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        post = post.toBuilder()
                .postTitle(postTitle)
                .postContent(postContent)
                .build();

        log.info("변경된 게시글 ============= > {}", post);

        postRepository.save(post); // 수정된 게시글 저장
    }

}
