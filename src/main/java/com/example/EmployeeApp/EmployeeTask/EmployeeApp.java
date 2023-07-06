package com.example.EmployeeApp.EmployeeTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EmployeeApp {

	public static void main(String[] args) {

		List<EmployeeEntity> users1 = new ArrayList<>();
		users1.add(new EmployeeEntity(1, "Amol", "Hase", "amol@gmail.com",new Date(2022-01-01)));
		users1.add(new EmployeeEntity(2, "Ajinkya", "Patil", "ajinkya@gmail.com",new Date(2021-07-01)));
		users1.add(new EmployeeEntity(1, "Amol", "Hase", "amol@gmail.com",new Date(2022-02-01)));
		users1.add(new EmployeeEntity(2, "Ajinkya", "Patil", "ajinkya@gmail.com",new Date(2021-07-01)));

		List<EmployeeEntity> users2 = new ArrayList<>();
		users2.add(new EmployeeEntity(4, "Suraj", "Kumar", "suraj@gmail.com",new Date(2020-06-01)));
		users2.add(new EmployeeEntity(3, "Rahul", "Tiwari", "rahul@gmail.com",new Date(2023-01-01)));

		System.out.println("Combined Employee list, sort it and print unique employee ");
		System.out.println("-------------------------------------------------------------------");
		List<EmployeeEntity> combinedList = Stream
				.concat(users1.stream(), users2.stream())
				.distinct()
				.sorted(Comparator.comparing(EmployeeEntity::getId))
				.collect(Collectors.toList());
		for (EmployeeEntity employee : combinedList) {
//			System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName() + " "
//					+ employee.getEmail() + " " + employee.getDoj());
			System.out.println(employee);
		}
	}
	
}
