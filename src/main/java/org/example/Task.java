package org.example;

import com.google.gson.annotations.JsonAdapter;

import java.util.Date;

public class Task {

    private String id;
    private String title;
    private boolean completed;
    
    @JsonAdapter(DateTypeAdapter.class)
    private Date created;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
