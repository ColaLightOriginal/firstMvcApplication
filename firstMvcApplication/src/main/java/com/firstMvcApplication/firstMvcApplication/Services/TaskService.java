package com.firstMvcApplication.firstMvcApplication.Services;
import com.firstMvcApplication.firstMvcApplication.Classes.Task;
import com.firstMvcApplication.firstMvcApplication.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TasksRepository tasksRepository = new TasksRepository();

    public List<Task> getAllTasks(){
        return tasksRepository.getAllTasks();
    }

    public List<Task> getEmployeeTasks(int empId){
        return tasksRepository.getEmpTasks(empId);
    }

    public void addTask(int empId, String description, int priority){
        tasksRepository.addTask(empId, description, priority);
    }
}
