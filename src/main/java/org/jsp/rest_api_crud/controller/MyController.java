package org.jsp.rest_api_crud.controller;

import java.util.List;

import org.aspectj.lang.annotation.DeclareMixin;
import org.jsp.rest_api_crud.dto.Student;
import org.jsp.rest_api_crud.helper.RepoStructure;
import org.jsp.rest_api_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //(@Controller+@ResponseBody)
@RequestMapping ("/api/v1")
public class MyController {
	@Autowired
	StudentService service;
	@PostMapping("/students")
	@ResponseBody
	public ResponseEntity<RepoStructure<Student>> insertData(@RequestBody Student student) {
		return service.saveData(student);
	}
	@PostMapping("/students/many")
	@ResponseBody
	public ResponseEntity<RepoStructure<List<Student>>> insertAll(@RequestBody List<Student> students){
		return service.saveAll(students);
	}
	@GetMapping("/students/fetchall")
	@ResponseBody
	public  ResponseEntity<RepoStructure<List<Student>>> fetchAll(){
		return service.fetchAll();
	}
	@GetMapping("/students/id/{id}")
	@ResponseBody
	public ResponseEntity<RepoStructure<Student>> findById(@PathVariable int id){
		return service.findById(id);
	}
	@GetMapping("/students/name/{name}")
	@ResponseBody
	public ResponseEntity<RepoStructure<List<Student>>> findBySname(@PathVariable String name){
		return service.findByname(name);
	}
	@GetMapping("/students/phno/{phno}")
	@ResponseBody
	public ResponseEntity<RepoStructure<Student>> findByPhno(@PathVariable long phno){
		return service.findByPhno(phno);
	}
	@GetMapping("/students/result/{result}")
	@ResponseBody
	public ResponseEntity<RepoStructure<List<Student>>> findByResult(@PathVariable String result){
		return service.findByResult(result);
	}
	@GetMapping("/students/percentage/graterthan/{percentage}")
	@ResponseBody
	public ResponseEntity<RepoStructure<List<Student>>> findByPercentageGraterThan(@PathVariable double percentage){
		return service.findByPercentageGraterThan(percentage);
	}
	@GetMapping("/students/percentage/lessthan/{percentage}")
	@ResponseBody
	public ResponseEntity<RepoStructure<List<Student>>> findByPercentageLessThan(@PathVariable double percentage){
		return service.findByPercentageLessThan(percentage);
	}
	@GetMapping("/students/maths/eng/{marks}")
	@ResponseBody
	public ResponseEntity<RepoStructure<List<Student>>> findByMathsWithEng(@PathVariable int marks){
		return service.findByMathsWitheng(marks);
	}
	@GetMapping("/students/nameormobile/{data}")
	@ResponseBody
	public ResponseEntity<RepoStructure<List<Student>>> findByNameOrMobile(@PathVariable String  data){
		return service.findByNameOrPhno(data);
	}
	@DeleteMapping("/students/id/{id}")
	public ResponseEntity<RepoStructure<Student>> deletByid(@PathVariable int id){
		return service.DeleteById(id);
	}
	@DeleteMapping("/students/phno/{phno}")
	public ResponseEntity<RepoStructure<Student>> DeeleteBynphno(@PathVariable long phno){
		return service.deleteByPhno(phno);
	}
	@PutMapping("/students")
	public ResponseEntity<RepoStructure<Student>> update(@RequestBody Student student) {
		return service.update(student);
	}
}
