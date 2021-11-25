package com.azspring2.spring2.model;

import com.azspring2.spring2.entity.ToDoEntity;

public class ToDoModel {

    private String title;
    private boolean completed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public static ToDoModel toModel (ToDoEntity task){
        ToDoModel toDoModel = new ToDoModel();
        toDoModel.setTitle(task.getTitle());
        toDoModel.setCompleted(task.isCompleted());

        return toDoModel;
    }

    public ToDoModel() {
    }

}
