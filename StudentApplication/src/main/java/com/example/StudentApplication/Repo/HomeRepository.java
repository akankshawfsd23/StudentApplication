package com.example.StudentApplication.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentApplication.Model.Student;

@Repository
public interface HomeRepository extends JpaRepository<Student, Integer>{

	
}
