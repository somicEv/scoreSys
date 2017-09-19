package com.ztkj.scoreSys.service;

import com.ztkj.scoreSys.dao.IStudentDao;
import com.ztkj.scoreSys.dao.impl.StudentDaoImpl;
import com.ztkj.scoreSys.model.Student;

public class StudentService {

    public Student getStudentInfoById(Integer id){
        IStudentDao studentDao = new StudentDaoImpl();
        return studentDao.getStuById(id);
    }

    public boolean updateStudentInfo(Student student) {
        IStudentDao iStudentDao = new StudentDaoImpl();
        return iStudentDao.updateStu(student);
    }

    public boolean addStudentInfo(Student student) {
        IStudentDao iStudentDao = new StudentDaoImpl();
        return iStudentDao.addStu(student);
    }

}
