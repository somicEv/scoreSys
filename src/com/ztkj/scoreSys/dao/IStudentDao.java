package com.ztkj.scoreSys.dao;

import com.ztkj.scoreSys.model.Student;

import java.util.List;

public interface IStudentDao {
    Student login(String tname, String tpwd);

    List<Student> getAllStus();

    Student getStuById(int id);

    boolean updateStu(Student stu);

    boolean delStu(int id);

    boolean addStu(Student stu);
}
