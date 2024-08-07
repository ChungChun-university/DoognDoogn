package com.chungchun.website.myclass.repository;

import com.chungchun.website.myclass.model.MyClass;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface MyClassRepository extends JpaRepository<MyClass,Integer> {
}
