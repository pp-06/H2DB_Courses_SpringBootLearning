package com.courses.h2dbcourses.Service;

import com.courses.h2dbcourses.Entity.Courses;
import com.courses.h2dbcourses.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CoursesRepository coursesRepository;

    //Get all Courses
    public List<Courses> getAllCourses(){
        return coursesRepository.findAll();
    }

    //Get Course by Id
    public Courses getCourseById(int id){
        return coursesRepository.findById(id).get();
    }

    //Create course
    public Courses createCourse(Courses course){
        return coursesRepository.save(course);
    }
    //Remove Course
    public void removeCourseById(int id){
        Optional<Courses> tempCourse= coursesRepository.findById(id);
        if (tempCourse.isEmpty()){
            throw new RuntimeException("Course id"+id+"doesn't exist!");
        }
        coursesRepository.deleteById(id);
    }
    //Remove all courses
    public void removeAllCourses(){
        coursesRepository.deleteAll();
    }
    //Get Count
    public long getCount(){
        return coursesRepository.count();
    }

    //Check Whether course Exist By Id
    public boolean courseExistenceById(int id){

        return coursesRepository.existsById(id);
    }
    //Update Entry
    public Courses updateCourse(Courses course){
        boolean courseIdExist = courseExistenceById(course.getCourseId());
        if (!courseIdExist){
            throw new RuntimeException("Course id"+course.getCourseId()+"doesn't exist!");
        }
        else if (course.getCourseName() == null){
            throw new RuntimeException("Please Provide a Course Name");
        }
        else if (course.getCourseDescription() == null){
            throw new RuntimeException("Please Provide a Course Description");
        }
        else{
            course.setCourseName(course.getCourseName());
            course.setCourseDescription(course.getCourseDescription());
            return course;
        }
    }

}
