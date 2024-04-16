package com.example.tugastodo;

public class TodoItem {
    private int id;
    private String what;
    private String time;

    // Constructor, getters, and setters
    public TodoItem(int id, String what, String time) {
        this.id = id;
        this.what = what;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getWhat() {
        return what;
    }

    public String getTime() {
        return time;
    }
}
