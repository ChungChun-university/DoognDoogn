package com.chungchun.website.course.controller;

import com.chungchun.website.course.model.Course;
import com.chungchun.website.course.model.CourseDTO;
import com.chungchun.website.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/course")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    // 강의 메인
    @GetMapping("/main")
    public String main(Model model) {

        List<Course> courseList = courseService.findAllCourse();

        model.addAttribute("courseList", courseList);

        return "course/courseMain";}

    // 하트 이미지 클릭시 나의 강의 페이지로 이동
    @GetMapping("/myCourse")
    public String myCourse() {return "myClass/myClassView";}


//    // 강의 검색
//    @GetMapping("/search")
//    public String searchCourse(@RequestParam(name = "clsName", required = false, defaultValue = "") String clsName, Model model) {
//
//        Iterable<Course> courses = courseService.findCourseByName(clsName);
//        model.addAttribute("courses", courses);
//        return "/course/search2";
//    }




//    // 강의 검색
//    @GetMapping("/search")
//    public String search(@AuthenticationPrincipal UserDetails userDetails, Model model) {
//        String clsName = userDetails.getUsername();
//        log.info("clsName : {}", clsName);
//
//        CourseDTO courseDTO = courseService.findCourseByName(clsName);
//        log.info("CourseDTO : {}", courseDTO);
//
//        model.addAttribute("course", courseDTO);
//        return "course/search";

//    }

//    // 수강신청
//    @GetMapping("/apply")
//    public String apply() {
//
//
//        return "course/courseMain/courseApply";
//    }

}
