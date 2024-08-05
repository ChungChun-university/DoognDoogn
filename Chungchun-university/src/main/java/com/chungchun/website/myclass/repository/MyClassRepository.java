package com.chungchun.website.myclass.repository;

import com.chungchun.website.myclass.common.MyClass;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface MyClassRepository extends JpaRepository<MyClass,Integer> {
}
