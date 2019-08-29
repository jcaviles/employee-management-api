package com.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
public class Employee {

	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;

}
