package com.example.messagingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {
    @Id
    private long id;
    private String message;

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {

    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
