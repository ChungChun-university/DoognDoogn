package com.chungchun.website.course.service;

import com.chungchun.website.course.model.Course;
import com.chungchun.website.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    // 전체 강의조회
    public List<Course> findAllCourse() {

        return courseRepository.findAll();
    }





}
