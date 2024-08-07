package com.chungchun.website.comment.repository;

//package com.chungchun.website.comment.common;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CommentRepository extends JpaRepository<com.chungchun.website.comment.common.Comment,Integer> {
}
