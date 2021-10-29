package com.suzumiya.model.user;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private int course_id;
    private Role role;
    private int role_id;
    private Course course;

    public User() {
        // Empty constructor
    }

    public User(int id){
        this.id = id;
    }

    public User(int id, int course_id) {
        this.id = id;
        this.course_id = course_id;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, String password, String email, int role_id) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role_id = role_id;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }


}
