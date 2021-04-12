package course.spring.hibernate;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")//對應表格名稱
public class Employee {
	@Id
	@Column(name="id")//對應欄位名稱
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="birthdate")
	private Date birthdate;
	
	@Column(name="salary")
	private float salary;
	
	
	
}
