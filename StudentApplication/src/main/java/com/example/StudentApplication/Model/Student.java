package com.example.StudentApplication.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student extends Exception{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int studId;
	
	private long rollNo;
	private String studName;
	private String address;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public long getRollNo() {
		return rollNo;
	}
	public void setRollNo(long l) {
		this.rollNo = l;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
