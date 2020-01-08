package com.firstMvcApplication.firstMvcApplication.Repositories;


import com.firstMvcApplication.firstMvcApplication.Classes.Task;
import com.firstMvcApplication.firstMvcApplication.Interfaces.TasksRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import static org.hibernate.cache.spi.support.SimpleTimestamper.next;

@Repository
public class TasksRepository implements TasksRepositoryInterface {

    private List<Task> tasks = new ArrayList<Task>();

    public TasksRepository() {
        tasks.add(new Task(1, 0, "Podlanie kwiatów", 1));
        tasks.add(new Task(2, 0, "Zmielenie kawy", 2));
        tasks.add(new Task(3, 0, "Cos tam2", 10));
        tasks.add(new Task(4, 1, "Pokonanie smoka", 8));
        tasks.add(new Task(5, 1, "Cos tam1", 10));
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public List<Task> getEmpTasks(int employeeId) {
        List<Task> result = new LinkedList<>();
        for (Task tsk : tasks) {
            if (tsk.getEmpId() == employeeId) {
                result.add(tsk);
            }
        }
        return result;
    }

    @Override
    public int findMaxPriority(int employeeId) {
        int maxPriority = -1;
        for (Task tsk : tasks) {
            if (tsk.getEmpId() == employeeId && tsk.getPriority() > maxPriority) {
                maxPriority = tsk.getPriority();
            }
        }
        return maxPriority;
    }

    @Override
    public List<Task> getTasksWithMaxPriority(int employeeId) {
        List<Task> result = new LinkedList<>();
        int maxPriority = findMaxPriority(employeeId);
        for (Task tsk : tasks) {
            if ((tsk.getEmpId() == employeeId) && (tsk.getPriority() == maxPriority)) {
                result.add(tsk);
            }
        }
        return result;
    }

    @Override
    public int getMaxId(){
        int maxId = -1;
        for(Task task : tasks){
            if(task.getId()>maxId) maxId=task.getId();
        }

        if(maxId==-1) return 0;
        else return maxId;
    }

    @Override
    public void addTask(int employeeId, String description, int priority){
        tasks.add(new Task(getMaxId()+1,employeeId,description,priority));
    }

    public void deleteEmpTasks(int empId){
        Predicate<Task> isDeletedEmpTask = task -> {
            return task.getId() == empId;
        };
        this.tasks.stream().filter(isDeletedEmpTask);
        this.tasks.removeIf(isDeletedEmpTask);
//        Iterator<Task> tsk = tasks.iterator();
//        Task actualTask = tasks.get(0);
//        while(tsk.hasNext()){
//            if(actualTask.getId()==empId) tsk.remove();
//            actualTask = tsk.next();
//        }
    }
}