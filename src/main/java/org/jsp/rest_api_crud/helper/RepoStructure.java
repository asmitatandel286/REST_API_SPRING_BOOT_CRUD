package org.jsp.rest_api_crud.helper;

import org.jsp.rest_api_crud.dto.Student;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RepoStructure<T> {
	String mes;
	int status;
	T data;
}
