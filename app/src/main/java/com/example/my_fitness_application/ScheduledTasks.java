package com.example.my_fitness_application;

public class ScheduledTasks {

    private String taskTitle, taskDate, taskDesc;

    public ScheduledTasks(String taskTitle, String taskDate, String taskDesc) {
        this.taskTitle = taskTitle;
        this.taskDate = taskDate;
        this.taskDesc = taskDesc;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
}
