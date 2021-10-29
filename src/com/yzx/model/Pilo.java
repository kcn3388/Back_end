package com.yzx.model;

public class Pilo {
    private int id;
    private int subject_id;
    private int pilo_id;
    private String content;


    public Pilo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getPilo_id() {
        return pilo_id;
    }

    public void setPilo_id(int pilo_id) {
        this.pilo_id = pilo_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
