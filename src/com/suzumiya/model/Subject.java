package com.suzumiya.model;

import com.suzumiya.model.user.Course;

import java.util.List;

public class Subject {
    private int id;
    private String code;
    private String title;
    private Course course;
    private String professor;
    private String teaching_assistant;
    private int unit;
    private int hours;
    private String pre_req;
    private String co_req;
    private String offer_unit;
    private String description;
    private List<TextBook> textBooks;
    private List<Content> contents;
    private List<Assessment> assessments;
    private List<Cilo> cilos;
    private List<Slo> slos;
    private List<Tls> tlss;
    private int course_id;
    private int prof_id;

    public Subject() {
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setTextBooks(List<TextBook> textBooks) {
        this.textBooks = textBooks;
    }

    public List<TextBook> getTextBooks() {
        return textBooks;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public List<Cilo> getCilos() {
        return cilos;
    }

    public void setCilos(List<Cilo> cilos) {
        this.cilos = cilos;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTeaching_assistant() {
        return teaching_assistant;
    }

    public void setTeaching_assistant(String teaching_assistant) {
        this.teaching_assistant = teaching_assistant;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getPre_req() {
        return pre_req;
    }

    public void setPre_req(String pre_req) {
        this.pre_req = pre_req;
    }

    public String getCo_req() {
        return co_req;
    }

    public void setCo_req(String co_req) {
        this.co_req = co_req;
    }

    public String getOffer_unit() {
        return offer_unit;
    }

    public void setOffer_unit(String offer_unit) {
        this.offer_unit = offer_unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public void setId (int id){
        this.id = id;
    }

    public List<Slo> getSlos() {
        return slos;
    }

    public void setSlos(List<Slo> slos) {
        this.slos = slos;
    }

    public List<Tls> getTlss() {
        return tlss;
    }

    public void setTlss(List<Tls> tlss) {
        this.tlss = tlss;
    }
}
