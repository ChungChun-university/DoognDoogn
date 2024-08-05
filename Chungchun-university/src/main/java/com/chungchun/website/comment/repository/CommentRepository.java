package com.chungchun.website.comment.repository;

import com.chungchun.website.comment.common.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}