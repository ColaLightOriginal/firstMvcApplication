package com.firstMvcApplication.firstMvcApplication.Interfaces;

import com.firstMvcApplication.firstMvcApplication.Classes.Employee;

import java.util.List;

public interface EmployeesRepositoryInterface {
    Employee findOne(int id);
    List<Employee> findAll();
}
