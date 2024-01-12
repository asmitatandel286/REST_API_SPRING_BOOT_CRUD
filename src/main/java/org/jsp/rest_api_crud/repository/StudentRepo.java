package org.jsp.rest_api_crud.repository;

import java.util.List;

import org.jsp.rest_api_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);

	Student findByPhno(long phno);

	List<Student> findByResult(String result);

	List<Student> findByPercentageGreaterThanEqual(double percentage);

	List<Student> findByPercentageLessThanEqual(double percentage);

	List<Student> findByMathsGreaterThanEqualAndEngGreaterThanEqual(int marks, int marks2);

	List<Student> findByNameOrPhno(String name, long phno);

	//void deleteByName(List<Student> list);

//	void deleteByName(String name);

	void deleteByPhno(long phno);

	//List<Student> findbyNameOrphno(String name, long phno);

	//List<Student> findByNameOrphno(Object object, long parseLong);

	//List<Student> findByNameOrPhno(String data, int i);

	//List<Student> findByNameOrPhno(String data, long phno);

	
	

	

	

}
