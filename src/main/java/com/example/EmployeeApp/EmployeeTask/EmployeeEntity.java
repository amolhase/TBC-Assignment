package com.example.EmployeeApp.EmployeeTask;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class EmployeeEntity {

	@Id
	@GeneratedValue
	private Integer id;

	private String firstName;
	private String lastName;
	private String email;
	private Date doj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(Integer id, String firstName, String lastName, String email, Date doj) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.doj = doj;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EmployeeEntity employee = (EmployeeEntity) o;
		return id == employee.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", doj=" + doj ;
	}

}
