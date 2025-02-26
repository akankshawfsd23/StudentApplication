package com.example.StudentApplication.Serv;

import java.util.List;
import java.util.Optional;

import com.example.StudentApplication.Model.Student;

public interface HomeService {

	//Post
	Student save(Student s);

	//Get ALL
	List<Student> getAllData();

	//Get Single
	Optional<Student> getStud(Student st2);

	//Put
	Student getStud(Integer sid, Student s);

	//delete
	void delStud(Integer sid);

	Optional<Student> getStud(Optional<Student> st2);

	Optional<Student> getStud(Integer sid);
	
}
