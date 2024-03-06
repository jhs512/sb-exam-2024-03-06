package com.ll;

public class Todo {
    private long id;
    private String content;

    private void setId() {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Todo(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
