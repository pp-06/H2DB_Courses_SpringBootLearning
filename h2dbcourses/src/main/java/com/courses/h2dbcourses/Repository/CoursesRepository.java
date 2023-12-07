package com.courses.h2dbcourses.Repository;

import com.courses.h2dbcourses.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {
}
