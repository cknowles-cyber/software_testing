package com.knowles.lab5.studentRegDemo.repository;

// import the model that defines the student data type.
import com.knowles.lab5.studentRegDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// uses inheritance to acquire the typical CRUD operations.
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Standard methods like save(), findAll(), and findById() are already here!
}