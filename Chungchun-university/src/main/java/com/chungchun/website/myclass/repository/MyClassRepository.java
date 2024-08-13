package com.chungchun.website.myclass.repository;

import com.chungchun.website.myclass.model.MyClass;
import com.chungchun.website.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface MyClassRepository extends JpaRepository<MyClass,Integer> {


    List<MyClass> findMyClassesByUser(User user);
}
