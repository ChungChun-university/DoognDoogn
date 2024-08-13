package com.chungchun.website.course.service;

import com.chungchun.website.course.model.Course;
import com.chungchun.website.course.model.CourseDTO;
import com.chungchun.website.course.repository.CourseRepository;
import com.chungchun.website.myclass.model.MyClass;
import com.chungchun.website.myclass.model.MyClassDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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
