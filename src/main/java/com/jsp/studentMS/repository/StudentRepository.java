package com.jsp.studentMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jsp.studentMS.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
