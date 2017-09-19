package com.ztkj.scoreSys.servlet.teacher;

import com.ztkj.scoreSys.dao.ITeacherDao;
import com.ztkj.scoreSys.dao.impl.TeacherDaoImpl;
import com.ztkj.scoreSys.model.Student;
import com.ztkj.scoreSys.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ITeacherDao teacherDao = new TeacherDaoImpl();
        List<Teacher> teacherList = teacherDao.getAllTeachers();
        for (Teacher t : teacherList) {
            System.out.println(t.toString());
        }
        // 添加学生列表
        request.setAttribute("teacherList", teacherList);
        System.out.println("跳转--tea_list.html");
        request.getRequestDispatcher("WEB-INF/views/teacher/teacher_list.jsp").forward(request, response);
    }
}
