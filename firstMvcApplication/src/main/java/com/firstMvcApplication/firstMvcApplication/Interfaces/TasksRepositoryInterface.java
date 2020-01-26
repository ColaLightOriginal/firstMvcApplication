package com.firstMvcApplication.firstMvcApplication.Interfaces;

import com.firstMvcApplication.firstMvcApplication.Classes.Task;

import java.util.List;

public interface TasksRepositoryInterface {
    List<Task> getAllTasks();
    List<Task> getEmpTasks(int employeeId);
    void addTask(int employeeId, String description, int priority);
    void removeTask(int taskId);
}
