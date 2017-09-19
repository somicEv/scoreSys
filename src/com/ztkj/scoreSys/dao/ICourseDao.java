package com.ztkj.scoreSys.dao;

import com.ztkj.scoreSys.model.Course;

import java.util.List;

public interface ICourseDao {

    List<Course> getAllCourses();

    Course getCourseById(int id);

    boolean addCourse(Course course);

    boolean updateCourse(Course course);

    boolean delCourse(int id);

}
