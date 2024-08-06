package com.chungchun.website.user.repository;

import com.chungchun.website.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
