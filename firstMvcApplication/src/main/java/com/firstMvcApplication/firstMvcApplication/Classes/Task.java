package com.firstMvcApplication.firstMvcApplication.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "priority", nullable = false)
    private int priority;
    @Column(name = "emp_id", nullable = false)
    private int empId;

    public Task(){ }

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
        this.empId =empId;
        this.description=description;
        this.priority=priority;
    }
}
