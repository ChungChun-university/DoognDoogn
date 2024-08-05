package com.chungchun.website.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CourseRepository extends JpaRepository<,Integer> {
}
