package com.example.recyclerview;

public class Todo {
    String topic;
    String desc;
    String status;
    String uid;

    public Todo(){

    }

    public Todo(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public Todo(String topic, String desc, String status) {
        this.topic = topic;
        this.desc = desc;
        this.status = status;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
