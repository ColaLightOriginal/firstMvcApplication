package com.firstMvcApplication.firstMvcApplication.Interfaces;

import com.firstMvcApplication.firstMvcApplication.Classes.Task;

import java.util.List;

public interface TasksRepositoryInterface {
    List<Task> getAllTasks();
    List<Task> getEmpTasks(int employeeId);
    List<Task> getTasksWithMaxPriority(int employeeId);
    int findMaxPriority(int employeeId);
    int getMaxId();
    void addTask(int employeeId, String description, int priority);
}
