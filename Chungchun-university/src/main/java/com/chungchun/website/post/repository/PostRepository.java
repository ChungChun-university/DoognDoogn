package com.chungchun.website.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PostRepository extends JpaRepository<,Integer> {
}
