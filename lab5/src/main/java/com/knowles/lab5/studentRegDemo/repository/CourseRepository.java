package com.knowles.lab5.studentRegDemo.repository;

import com.knowles.lab5.studentRegDemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
