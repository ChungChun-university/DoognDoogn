package com.chungchun.website.comment.repository;

import com.chungchun.website.comment.common.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Entity,Integer> {
}
