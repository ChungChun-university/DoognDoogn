package com.chungchun.website.user.repository;

import com.chungchun.website.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByUserId(String userId);

    Optional<User> findByUserNo(int userNo);


    User findUserByUserPhone(String userPhone);

    User findByUserId(String userId); // ID로 사용자 조회

    User findByUserNameAndUserPhone(String userName, String userPhone);

}
