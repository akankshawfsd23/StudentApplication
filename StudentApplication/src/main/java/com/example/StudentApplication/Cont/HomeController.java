package com.example.StudentApplication.Cont;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.StudentApplication.Model.Student;
import com.example.StudentApplication.Serv.HomeService;

@Controller
@RequestMapping("/hello")
public class HomeController {
	
	@Autowired
	HomeService hs;
	
	@PostMapping("/postdataa")
	public ResponseEntity<Student> add(@RequestBody Student s){
		return new ResponseEntity<Student>(hs.save(s),HttpStatus.OK);
	}
	//get all data from db
	@GetMapping("/getdata")
	public ResponseEntity<List<Student>> getAllData(){
		List<Student> st=hs.getAllData();
		if(st.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(st,HttpStatus.OK);
	}
	
	//get single data from db
	@GetMapping("/getStud/{sid}")
	public ResponseEntity<Optional<Student>> getStud(@PathVariable Integer sid){
		Optional<Student> st=hs.getStud(sid);
		return new ResponseEntity<Optional<Student>>(st,HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/updatestud/{sid}")
	public ResponseEntity<Student> upd_stud(@PathVariable Integer sid,@RequestBody Student s)
	{	Student st=hs.getStud(sid,s);
		return new ResponseEntity<Student>(st,HttpStatus.ACCEPTED);
	}
	
	//Delete
//	@DeleteMapping("/delStud/{sid}")
//	public ResponseEntity<String> delStud(@PathVariable Integer sid)
//	{
//		hs.delStud(sid);
//		return new  ResponseEntity<String>(HttpStatus.NO_CONTENT);
//	}

	@DeleteMapping("/delStud1/{sid}")
	public ResponseEntity<String> delStud(@PathVariable Integer sid)
	{
		hs.delStud(sid);
		return new  ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}



}
