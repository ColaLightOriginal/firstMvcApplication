package com.firstMvcApplication.firstMvcApplication.Controllers;

import com.firstMvcApplication.firstMvcApplication.Classes.Task;
import com.firstMvcApplication.firstMvcApplication.Repositories.TasksRepository;
import com.firstMvcApplication.firstMvcApplication.Services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "tasks")
@RestController
public class TasksController {

    private TasksRepository taskRepository;
    private TaskService taskService;

    public TasksController(TasksRepository taskRepository, TaskService taskService)
        {
            this.taskRepository = taskRepository;
            this.taskService = taskService;
        }

    @GetMapping(value = "getTasks")
    public List<Task> getTasks(){
        System.out.println(taskService.getAllTasks());
        return taskService.getAllTasks();
    }

    @GetMapping(value = "findById/{employeeId}")
    public List<Task> getTasksById(@PathVariable int employeeId) {
        return taskService.getEmployeeTasks(employeeId);
    }

    @PostMapping(value = "addTask/{employeeId}/{description}/{priority}")
    public void addTask(@PathVariable Map<String, String> pathVariable){
            taskService.addTask(Integer.parseInt(pathVariable.get("employeeId")),pathVariable.get("description"),Integer.parseInt(pathVariable.get("priority")));
    }
}