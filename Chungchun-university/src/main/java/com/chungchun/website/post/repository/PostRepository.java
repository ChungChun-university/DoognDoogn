package com.chungchun.website.post.repository;

import com.chungchun.website.post.model.Post;
import com.chungchun.website.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Optional<Post> findByPostNo(int postNo);

    List<Post> findPostsByUserNo(User user);
}
