package org.jsp.rest_api_crud.service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.NoSuchElementException;

import org.jsp.rest_api_crud.dao.MyDao;
import org.jsp.rest_api_crud.dto.Student;
import org.jsp.rest_api_crud.helper.RepoStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	RepoStructure<Student> structure;
	@Autowired
	RepoStructure<List<Student>> structure1;
	@Autowired
	MyDao dao;
	//1. save one records
	public ResponseEntity<RepoStructure<Student>> saveData(Student student) {
		student.setAge(Period.between(student.getDob(), LocalDate.now()).getYears());
		student.setPercentage((student.getEng() + student.getMaths() + student.getScience()) / 3.0);
		if (student.getEng() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
			student.setResult("fail");
		} else {
			if (student.getPercentage() >= 85) {
				student.setResult("Distinction");
			} else if (student.getPercentage() >= 70) {
				student.setResult("frist class");
			} else if (student.getPercentage() >= 55) {
				student.setResult("second class");
			} else {
				student.setResult("Third class");
			}
		}
		structure.setMes("Data saved Success");
		structure.setData(dao.save(student));
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<RepoStructure<Student>>(structure, HttpStatus.CREATED);
	}
	//2. save all records
	public ResponseEntity<RepoStructure<List<Student>>> saveAll(List<Student> students) {
		for (Student student : students) {
			student.setAge(Period.between(student.getDob(), LocalDate.now()).getYears());
			student.setPercentage((student.getEng() + student.getMaths() + student.getScience()) / 3.0);
			if (student.getEng() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
				student.setResult("fail");
			} else {
				if (student.getPercentage() >= 85) {
					student.setResult("Distinction");
				} else if (student.getPercentage() >= 70) {
					student.setResult("frist class");
				} else if (student.getPercentage() >= 55) {
					student.setResult("second class");
				} else {
					student.setResult("Third class");
				}
			}
			dao.saveAll(students);
			structure1.setMes("Data saved Success");
			structure1.setData(students);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.CREATED.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.CREATED);
	}
	//3. fetch all data
	public ResponseEntity<RepoStructure<List<Student>>> fetchAll() {

		List<Student> list=dao.fetchAll();
		if(list.isEmpty()) {
			throw new NoSuchElementException("Data not present ");
		}else {
			structure1.setMes(list.size()+" number of record found");
			structure1.setData(list);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.FOUND.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}
	//4. fetch by id
	public ResponseEntity<RepoStructure<Student>> findById(int id) {
		Student student=dao.findById(id);
		if(student==null) {
			throw new NoSuchElementException("Data not foun with id:"+id);
		}
		structure.setMes("data found with id:"+id);
		structure.setData(student);
		structure.setStatus(HttpStatus.FOUND.value());
	
		return new ResponseEntity<RepoStructure<Student>>(structure, HttpStatus.FOUND);
	}
	//5. fetch by name
	public ResponseEntity<RepoStructure<List<Student>>> findByname(String name) {
		List<Student> list=dao.findByName(name);
		if(list.isEmpty()) {
			throw new NoSuchElementException(" Data not foun with name:"+name);
		}else {
			structure1.setMes(list.size()+" data foun with the name");
			structure1.setData(list);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.FOUND.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}
	//6. fetch by phone
	public ResponseEntity<RepoStructure<Student>> findByPhno(long phno) {
		Student student=dao.findByPhno(phno);
		if(student==null) {
			throw new NoSuchElementException("Data not foun with phone:"+phno);
		}
		structure.setMes("data found with id:"+phno);
		structure.setData(student);
		structure.setStatus(HttpStatus.FOUND.value());
	
		return new ResponseEntity<RepoStructure<Student>>(structure, HttpStatus.FOUND);
	}
	//7. fetch by result
	public ResponseEntity<RepoStructure<List<Student>>> findByResult(String result) {
		List<Student> list=dao.findByResult(result);
		if(list.isEmpty()) {
			throw new NoSuchElementException(" Data not foun with Result:"+result);
		}else {
			structure1.setMes(list.size()+" data foun with the reesult");
			structure1.setData(list);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.FOUND.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}
	//8.fetch by percentage graterthan
	public ResponseEntity<RepoStructure<List<Student>>> findByPercentageGraterThan(double percentage) {
		List<Student> list=dao.findByPercentageGreaterThanEqual(percentage);
		if(list.isEmpty()) {
			throw new NoSuchElementException(" Data not foun with Percentage:"+percentage);
		}else {
			structure1.setMes(list.size()+" data foun with the reesult");
			structure1.setData(list);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.FOUND.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}
	//9.fetch by percentage lessthan
	public ResponseEntity<RepoStructure<List<Student>>> findByPercentageLessThan(double percentage) {
		List<Student> list=dao.findByPercentageLessThanEqual(percentage);
		if(list.isEmpty()) {
			throw new NoSuchElementException(" Data not foun with Percentage:"+percentage);
		}else {
			structure1.setMes(list.size()+" data found with the percentage");
			structure1.setData(list);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.FOUND.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}
	//10.fetch by maths with english marks
	public ResponseEntity<RepoStructure<List<Student>>> findByMathsWitheng(int marks) {
		List<Student> list=dao.findByMathsWitheng(marks);
		if(list.isEmpty()) {
			throw new NoSuchElementException(" Data not found with maths "+marks+" and english "+marks);
		}else {
			structure1.setMes(list.size()+" data found with the marks grater than"+marks+" in maths and engish");
			structure1.setData(list);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.FOUND.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}
	//11.fetch by name or phno
	public ResponseEntity<RepoStructure<List<Student>>> findByNameOrPhno(String data) {
		List<Student> students=null;
		try {
			students=dao.fecthbyNameorphno(null,Long.parseLong(data));

		}catch(NumberFormatException e) {
			students=dao.fecthbyNameorphno(data,0);
		}
		if(students.isEmpty()) {
			throw new NoSuchElementException(" Data not found");
		}else {
			structure1.setMes(" data found ");
			structure1.setData(students);
			// structure1.setData(students);
			structure1.setStatus(HttpStatus.FOUND.value());

		}
		return new ResponseEntity<RepoStructure<List<Student>>>(structure1, HttpStatus.FOUND);

	}
	//12.delete by id
	public ResponseEntity<RepoStructure<Student>> DeleteById(int id) {
		Student student=dao.findById(id);
		if(student==null) {
			throw new NoSuchElementException("Data not foun with id:"+id);
		}
		dao.deletById(id);
		structure.setMes("data deleted with id:"+id);
		structure.setData(student);
		structure.setStatus(HttpStatus.OK.value());
	
		return new ResponseEntity<RepoStructure<Student>>(structure, HttpStatus.OK);
	}
	//13. delete by phnoe
	public ResponseEntity<RepoStructure<Student>> deleteByPhno(long phno) {
		Student student=dao.findByPhno(phno);
		if(student==null) {
			throw new NoSuchElementException("Data not foun with phno:"+phno);
		}
		dao.deletByPhno(phno);
		structure.setMes("data deleted with phno:"+phno);
		structure.setData(student);
		structure.setStatus(HttpStatus.OK.value());
	
		return new ResponseEntity<RepoStructure<Student>>(structure, HttpStatus.OK);
	}
	public ResponseEntity<RepoStructure<Student>> update(Student student) {
		student.setAge(Period.between(student.getDob(), LocalDate.now()).getYears());
		student.setPercentage((student.getEng() + student.getMaths() + student.getScience()) / 3.0);
		if (student.getEng() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
			student.setResult("fail");
		} else {
			if (student.getPercentage() >= 85) {
				student.setResult("Distinction");
			} else if (student.getPercentage() >= 70) {
				student.setResult("frist class");
			} else if (student.getPercentage() >= 55) {
				student.setResult("second class");
			} else {
				student.setResult("Third class");
			}
		}
		structure.setMes("Data updated Success");
		structure.setData(dao.save(student));
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<RepoStructure<Student>>(structure, HttpStatus.CREATED);
	
	}
	
	
}
