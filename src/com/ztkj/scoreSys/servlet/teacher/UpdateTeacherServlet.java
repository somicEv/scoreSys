package com.ztkj.scoreSys.servlet.teacher;

import com.ztkj.scoreSys.model.Teacher;
import com.ztkj.scoreSys.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTeacherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String tname = request.getParameter("tname");
        String tpwd = request.getParameter("tpwd");
        String collage = request.getParameter("collage");
        Teacher teacher = new Teacher(tname, tpwd, collage);
        teacher.setId(Integer.parseInt(id));
        TeacherService teacherService = new TeacherService();
        boolean b = teacherService.updateTeacherInfo(teacher);
        if(!b){
            // 如果不成功
            request.getRequestDispatcher("WEB-INF/views/teacher/teacher_update.jsp").forward(request, response);
        }
        response.sendRedirect("/showTeacherInfo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        TeacherService teacherService = new TeacherService();
        Teacher teacherInfo = teacherService.getTeacherInfo(Integer.parseInt(teacherId));
        request.setAttribute("teacherInfo", teacherInfo);
        request.getRequestDispatcher("WEB-INF/views/teacher/teacher_update.jsp").forward(request, response);
    }
}
