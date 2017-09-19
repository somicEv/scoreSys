package com.ztkj.scoreSys.service;

import com.ztkj.scoreSys.dao.ICourseDao;
import com.ztkj.scoreSys.dao.ITeacherDao;
import com.ztkj.scoreSys.dao.impl.CourseDaoImpl;
import com.ztkj.scoreSys.dao.impl.TeacherDaoImpl;
import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.model.Teacher;

import java.util.List;

public class CourseService {

    public List<Course> selectCourseList(){
        ICourseDao iCourseDao = new CourseDaoImpl();
        return iCourseDao.getAllCourses();
    }

    public boolean updateCourseInfo(Course course) {
        ICourseDao iCourseDao = new CourseDaoImpl();
        return iCourseDao.updateCourse(course);
    }

    public Course selectCourseInfo(Integer id) {
        ICourseDao iCourseDao = new CourseDaoImpl();
        return iCourseDao.getCourseById(id);
    }

    public boolean deleteCourseInfo(Integer id) {
        ICourseDao iCourseDao = new CourseDaoImpl();
        return iCourseDao.delCourse(id);
    }

    public boolean addCourseInfo(Course course,Integer tid) {
        ITeacherDao iTeacherDao = new TeacherDaoImpl();
        Teacher teacherById = iTeacherDao.getTeacherById(tid);
        course.setTeacher(teacherById);
        ICourseDao iCourseDao = new CourseDaoImpl();
        return iCourseDao.addCourse(course);
    }
}
