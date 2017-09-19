package com.ztkj.scoreSys.model;

public class Score {

    private int id;
    private Student stu;
    private Course course;
    private double score;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Student getStu() {
        return stu;
    }
    public void setStu(Student stu) {
        this.stu = stu;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

}
