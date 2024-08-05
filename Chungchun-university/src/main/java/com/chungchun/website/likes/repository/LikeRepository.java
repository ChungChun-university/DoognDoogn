package com.chungchun.website.likes.repository;

import com.chungchun.website.likes.common.Like;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {
}