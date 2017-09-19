package com.ztkj.scoreSys.service;

import com.ztkj.scoreSys.dao.ICourseDao;
import com.ztkj.scoreSys.dao.impl.CourseDaoImpl;
import com.ztkj.scoreSys.model.Course;

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
}
