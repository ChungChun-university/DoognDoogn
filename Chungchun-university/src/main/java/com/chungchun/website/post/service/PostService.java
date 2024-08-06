package com.chungchun.website.post.service;

import com.chungchun.website.post.model.Post;
import com.chungchun.website.post.model.PostDTO;
import com.chungchun.website.post.repository.PostRepository;
import com.chungchun.website.user.model.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;



    public List<Post> findAllPosts() {

           List<Post> allPosts = postRepository.findAll();

           return allPosts;
    }

    public void create(PostDTO postDTO, UserDTO user) {

        Post post = Post.builder()
                .postTitle(postDTO.getPostTitle())
                .postContent(postDTO.getPostContent())
                .categoryCode(postDTO.getCategoryCode())
                .build();
    }
}
