package com.chungchun.website.course.repository;

import com.chungchun.website.course.common.Course;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
