package com.suzumiya.model;

import java.util.List;

public class Assessment {
    private int id;
    private int subject_id;
    private String method;
    private int weighting;
    private String description;
    private List<Integer> cilo_ids;

    private List<Subject> subjects;

    public Assessment() {
    }

    public List<Integer> getCilo_ids() {
        return cilo_ids;
    }

    public void setCilo_ids(List<Integer> cilo_ids) {
        this.cilo_ids = cilo_ids;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getWeighting() {
        return weighting;
    }

    public void setWeighting(int weighting) {
        this.weighting = weighting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
