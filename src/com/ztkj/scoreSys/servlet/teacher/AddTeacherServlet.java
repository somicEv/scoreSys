package com.ztkj.scoreSys.servlet.teacher;

import com.ztkj.scoreSys.dao.ITeacherDao;
import com.ztkj.scoreSys.dao.impl.TeacherDaoImpl;
import com.ztkj.scoreSys.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String teacherName = request.getParameter("teacherName");
        String teacherPassword = request.getParameter("teacherPassword");
        String collage = request.getParameter("collage");
        Teacher teacher = new Teacher();
        teacher.setTname(teacherName);
        teacher.setTpwd(teacherPassword);
        teacher.setCollage(collage);
        ITeacherDao iTeacherDao = new TeacherDaoImpl();
        boolean flag = iTeacherDao.addTeacher(teacher);
        response.sendRedirect("/showTeacherInfo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/teacher/teacher_add.jsp").forward(request, response);
    }
}
