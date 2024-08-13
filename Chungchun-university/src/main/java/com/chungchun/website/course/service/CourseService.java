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

//    // 강의 검색
//    public Iterable<Course> findCourseByName(String clsName) {
//        return courseRepository.findByCourse(clsName);
//    }


//    private final CourseRepository courseRepository;
//    private final ModelMapper modelMapper;
//
//    public CourseDTO findCourseByName(String clsName) {
//        Course course = courseRepository.findCourseByClsNameContains(clsName)
//                .orElseThrow(() -> new NoSuchElementException("해당 강의를 찾을 수 없습니다."));
//
//        return modelMapper.map(course, CourseDTO.class);
//    }

//    // 수강신청
//    @Transactional
//    public void saveCourseApply(){
//
//        MyClass myClass = MyClass.builder()
//                .user()
//                .course(1)
//                .build();
//    }





}
