package com.chungchun.website.post.repository;

import com.chungchun.website.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
