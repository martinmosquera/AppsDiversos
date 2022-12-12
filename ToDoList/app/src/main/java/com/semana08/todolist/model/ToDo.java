package com.semana08.todolist.model;

import java.io.Serializable;

public class ToDo implements Serializable {

    private long id;
    private String toDoName;

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getToDoName() {
        return toDoName;
    }

    public void setToDoName(String toDoName) {
        this.toDoName = toDoName;
    }
}
