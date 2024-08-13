package com.chungchun.website.course.repository;

import com.chungchun.website.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

//    Optional<Course> findCourseByClsNameContains(String clsName);

//    Iterable<Course> findByCourse(String clsName);
}
