package com.chungchun.website.user.repository;

import com.chungchun.website.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByUserId(String userId);

    Optional<User> findByUserNo(int userNo);
}
