package com.courses.h2dbcourses.Repository;

import com.courses.h2dbcourses.Entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnersRepository extends JpaRepository<Learners,Integer> {
}
