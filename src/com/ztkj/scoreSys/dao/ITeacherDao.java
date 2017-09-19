package com.ztkj.scoreSys.dao;

import com.ztkj.scoreSys.model.Teacher;

import java.util.List;

public interface ITeacherDao {
    Teacher login(String tname, String tpwd);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(int id);

    boolean delTeacher(int id);

    boolean updateTeacher(Teacher teacher);

    boolean addTeacher(Teacher teacher);
}
