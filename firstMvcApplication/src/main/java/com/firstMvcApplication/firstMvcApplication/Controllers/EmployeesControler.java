package com.firstMvcApplication.firstMvcApplication.Controllers;

import com.firstMvcApplication.firstMvcApplication.Classes.Employee;
import com.firstMvcApplication.firstMvcApplication.Repositories.EmployeeRepository;
import com.firstMvcApplication.firstMvcApplication.Services.EmployeeService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "employees")
@RestController
public class EmployeesControler {

    private final EmployeeRepository employees;
    @Autowired
    private final EmployeeService employeeService = new EmployeeService();

    public EmployeesControler(EmployeeRepository employees) {
        this.employees = employees;
    }

    @GetMapping(value = "getEmployees")
    public List<Employee> getEmployeeList(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "findById/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping(value = "findByName/{employeeName}/{employeeSurname}")
    public Employee getEmployeeByName(@PathVariable Map<String, String> pathVariables){
        return employeeService.getEmployeeByName(pathVariables.get("employeeName"), pathVariables.get("employeeSurname"));
    }

    @PostMapping(value = "addEmployee/{employeeName}/{employeeSurname}")
    public void addNewEmployee(@PathVariable Map<String, String> pathVariable){
        employeeService.addEmployee(pathVariable.get("employeeName"),pathVariable.get("employeeSurname"));
    }

    @DeleteMapping(value = "removeEmployee/{employeeId}")
    public void removeEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}