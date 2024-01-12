package org.jsp.rest_api_crud.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.jsp.rest_api_crud.dto.Student;
import org.jsp.rest_api_crud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyDao {

	@Autowired
	StudentRepo repo;

	public Student save(Student student) {
		return repo.save(student);
	}
	public List<Student> saveAll(List<Student> students) {
		return repo.saveAll(students);
	}
	public List<Student> fetchAll() {
		return repo.findAll();
	}
	public Student findById(int id) {
		return repo.findById(id).orElseThrow(()->new NoSuchElementException("data not found with id:"+id));
	}
	public List<Student> findByName(String name) {
		return repo.findByName(name);
	}
	public Student findByPhno(long phno) {
		return repo.findByPhno(phno);
	}
	public List<Student> findByResult(String result) {
		return repo.findByResult(result);
	}
	public List<Student> findByPercentageGreaterThanEqual(double percentage) {
		return repo.findByPercentageGreaterThanEqual(percentage);
	}
	public List<Student> findByPercentageLessThanEqual(double percentage) {
		return repo.findByPercentageLessThanEqual(percentage);
	}
	public List<Student> findByMathsWitheng(int marks) {
		return repo.findByMathsGreaterThanEqualAndEngGreaterThanEqual(marks,marks);
	}
	public List<Student> fecthbyNameorphno(String name, long phno) {
		return repo.findByNameOrPhno(name, phno);
	}
	public void deletById(int id) {
		repo.deleteById(id);
	}
	public void deletByPhno(long phno) {
		repo.deleteByPhno(phno);
	}
	
	

}
