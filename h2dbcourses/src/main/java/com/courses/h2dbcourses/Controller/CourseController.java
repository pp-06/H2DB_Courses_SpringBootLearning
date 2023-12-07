package com.courses.h2dbcourses.Controller;

import com.courses.h2dbcourses.Entity.Courses;
import com.courses.h2dbcourses.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/getAll")
    public List<Courses> getAllCourses(){
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @PostMapping("/add")
    public Courses addCourse(@RequestBody Courses course){
        return courseService.createCourse(course);
    }

    @PutMapping("/update")
    public Courses updateCourse(@RequestBody Courses course){
        return courseService.updateCourse(course);
    }

    @GetMapping("/del/{id}")
    public void removeCourseById(@PathVariable int id){
        courseService.removeCourseById(id);
    }

    @GetMapping("/delAll")
    public void removeAllCourses(){
        courseService.removeAllCourses();
    }
    @GetMapping("/count")
    public long getCount(){
        return courseService.getCount();
    }

    @GetMapping("/existById/{id}")
    public boolean courseExistenceById(@PathVariable int id){
        return courseService.courseExistenceById(id);
    }


}
