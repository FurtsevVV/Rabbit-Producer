package com.zakat.rabbitproducer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Message implements Serializable{

    private int id;
    private String text;

    public Message() {
    }

    public Message(@JsonProperty("id") int id, @JsonProperty("text") String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
