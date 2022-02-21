package com.todo.entity;

public class Task {
    private int id;
    private String task_name;
    private String task_desc;
    private int priority;

    public Task(int id, String task_name, String task_desc, int priority) {
        this.id = id;
        this.task_name = task_name;
        this.task_desc = task_desc;
        this.priority = priority;
    }

    public Task(String task_name, String task_desc, int priority) {
        this.task_name = task_name;
        this.task_desc = task_desc;
        this.priority = priority;
    }

    public Task(String task_name, String task_desc) {
        this.task_name = task_name;
        this.task_desc = task_desc;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", task_name=" + task_name + ", task_desc="
                + task_desc + ", priority=" + priority + "]";
    }




}
