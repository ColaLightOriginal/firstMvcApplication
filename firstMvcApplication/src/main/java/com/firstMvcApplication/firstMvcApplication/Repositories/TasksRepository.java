package com.firstMvcApplication.firstMvcApplication.Repositories;


import com.firstMvcApplication.firstMvcApplication.Classes.Task;
import com.firstMvcApplication.firstMvcApplication.Interfaces.TasksRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.awt.image.ImageWatched;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class TasksRepository implements TasksRepositoryInterface {

    @Autowired
    private EntityManager sessionFactory;

    public TasksRepository() {
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> resultList = new LinkedList<>();
        try {
            String query = "select task from Task task";
            TypedQuery<Task> tq = sessionFactory.createQuery(query, Task.class);
            resultList = tq.getResultList();
            return resultList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Task> getEmpTasks(int employeeId) {
        List<Task> resultList = new LinkedList<>();
        try{
            String query = "select empId from Task task where empId = :empId";
            TypedQuery<Task> tq = sessionFactory.createQuery(query,Task.class);
            tq.setParameter("empId", employeeId);
            resultList = tq.getResultList();
            return resultList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int findMaxPriority(int employeeId) {
        return 0;
    }

    @Override
    public List<Task> getTasksWithMaxPriority(int employeeId) {
        List<Task> tasks = new LinkedList<Task>();
        return tasks;
    }

    @Override
    public int getMaxId(){
        return 0;
    }

    @Override
    public void addTask(int employeeId, String description, int priority){
    }

    public void deleteEmpTasks(int empId){
    }
}