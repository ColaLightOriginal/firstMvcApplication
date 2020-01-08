package com.firstMvcApplication.firstMvcApplication.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.firstMvcApplication.firstMvcApplication.Classes.Employee;
import com.firstMvcApplication.firstMvcApplication.Repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeesRepository = new EmployeeRepository();

    public List<Employee> getAllEmployees(){
        return employeesRepository.findAll();
    }

    public Employee getEmployee(int id){
        return employeesRepository.findOne(id);
    }

    public Employee getEmployeeByName(String name, String surname){
        return employeesRepository.findByNameSurname(name, surname);
    }

    public void addEmployee(String name, String surname){
        employeesRepository.addEmployee(name, surname);
    }

    public void deleteEmployee(int id){
        employeesRepository.removeEmployee(id);
    }
}
