package com.example.StudentApplication.ServImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StudentApplication.Model.Student;
import com.example.StudentApplication.Repo.HomeRepository;
import com.example.StudentApplication.Serv.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	HomeRepository hr;

	//Post
	@Override
	public Student save(Student s) {
		return hr.save(s);
	}

	//GetAll
	@Override
	public List<Student> getAllData() {
		// TODO Auto-generated method stub
		return hr.findAll();
	}

	//GetSingle
	@Override
	public Optional<Student> getStud(Integer sid) 
	{
		
		return hr.findById(sid);
	}

	//Put
	@Override
	public Student getStud(Integer sid, Student s) {
			Optional<Student> opst=hr.findById(sid);
			if(opst.isPresent())
			{
				Student st=opst.get();
				st.setRollNo(s.getRollNo());
				st.setStudName(s.getStudName());
				st.setAddress(s.getAddress());
				System.out.println(st.getRollNo()+"/n"+st.getStudName()+"/n"+st.getAddress());
				return hr.save(st);
			}
			else 
			{
				System.out.println("No Student Found");
				return null;
			}

	}

	@Override
	public void delStud(Integer sid) {
		hr.deleteById(sid);	
	}

//	@Override
//	public Optional<Student> getStud(Optional<Student> st2) {
//		return hr.delete(st2);
//	}

	

	@Override
	public Optional<Student> getStud(Student st2) {
		// TODO Auto-generated method stub
		 this.hr.delete(st2);
		return Optional.empty();
	}

	@Override
	public Optional<Student> getStud(Optional<Student> st2) {
		// TODO Auto-generated method stub
		return null;
	}


}
