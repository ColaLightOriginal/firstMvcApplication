package com.firstMvcApplication.firstMvcApplication.Controllers;

import com.firstMvcApplication.firstMvcApplication.Classes.Task;
import com.firstMvcApplication.firstMvcApplication.Repositories.TasksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "tasks")
@RestController
public class TasksController {

    private TasksRepository taskRepository;

    public TasksController(TasksRepository taskRepository) { this.taskRepository = taskRepository; }

    @GetMapping(value = "getTasks")
    public List<Task> getTasks(){
        System.out.println(taskRepository.getAllTasks());
        return taskRepository.getAllTasks();
    }

    @GetMapping(value = "findById/{employeeId}")
    public List<Task> getTasksById(@PathVariable int employeeId) {
        return taskRepository.getEmpTasks(employeeId);
    }

    @PostMapping(value = "addTask/{employeeId}/{description}/{priority}")
    public void addTask(@PathVariable Map<String, String> pathVariable){
            taskRepository.addTask(Integer.parseInt(pathVariable.get("employeeId")),pathVariable.get("description"),Integer.parseInt(pathVariable.get("priority")));
    }
}