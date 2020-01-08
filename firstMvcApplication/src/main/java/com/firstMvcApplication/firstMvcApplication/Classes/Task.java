package com.firstMvcApplication.firstMvcApplication.Classes;

public class Task {

    private int id;
    private String description;
    private int priority;
    private int empId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Task(int id, int empId, String description, int priority){
        this.id=id;
        this.empId=empId;
        this.description=description;
        this.priority=priority;
    }
}
