package com.ztkj.scoreSys.service;

import com.ztkj.scoreSys.dao.ITeacherDao;
import com.ztkj.scoreSys.dao.impl.TeacherDaoImpl;
import com.ztkj.scoreSys.model.Teacher;

public class TeacherService {

    /**
     * 根据ID 查询教师信息
     *
     * @param id
     * @return
     */
    public Teacher getTeacherInfo(Integer id) {
        ITeacherDao iTeacherDao = new TeacherDaoImpl();
        Teacher teacherById = iTeacherDao.getTeacherById(id);
        System.out.println(teacherById);
        if (teacherById == null) {
            return null;
        }
        return teacherById;
    }

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     */
    public boolean updateTeacherInfo(Teacher teacher) {
        ITeacherDao iTeacherDao = new TeacherDaoImpl();
        return iTeacherDao.updateTeacher(teacher);
    }

    /**
     * 删除教师信息
     *
     * @param teacherId
     * @return
     */
    public boolean deleteTeacherInfo(Integer teacherId) {
        ITeacherDao iTeacherDao = new TeacherDaoImpl();
        return iTeacherDao.delTeacher(teacherId);
    }


}
