package com.firstMvcApplication.firstMvcApplication.Services;
import com.firstMvcApplication.firstMvcApplication.Repositories.TasksRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.firstMvcApplication.firstMvcApplication.Classes.Employee;
import com.firstMvcApplication.firstMvcApplication.Repositories.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeesRepository = new EmployeeRepository();

    @Autowired
    private final TasksRepository tasksRepository = new TasksRepository();

    @Autowired
    private EntityManager sessionFactory;

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

    @Transactional
    public void deleteEmployee(int id){
        Session session = sessionFactory.unwrap(Session.class);
        session.beginTransaction();
        tasksRepository.removeEmpTask(id,session);
        employeesRepository.removeEmployee(id,session);
        session.getTransaction().commit();
        session.close();
    }
}
