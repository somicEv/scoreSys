package com.ztkj.scoreSys.servlet.student;

import com.ztkj.scoreSys.model.Classes;
import com.ztkj.scoreSys.model.Student;
import com.ztkj.scoreSys.service.ClassesService;
import com.ztkj.scoreSys.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 封装成 createStudent(HttpServletRequest request)
        request.setCharacterEncoding("UTF-8");
        String stuno = request.getParameter("stuno");
        String stuname = request.getParameter("stuname");
        String pwd = request.getParameter("pwd");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String classid = request.getParameter("classid");
        // 根据classid 查询 Classes
        ClassesService classesService = new ClassesService();
        Classes classes = classesService.selectClassInfo(Integer.parseInt(classid));
        Student student = new Student(stuno, stuname, pwd, gender, birthday, Integer.parseInt(age), classes);
        StudentService studentService = new StudentService();
        boolean b = studentService.addStudentInfo(student);
        if (!b){
            // 不成功
            request.getRequestDispatcher("WEB-INF/views/students/stu_add.jsp").forward(request, response);
        }
        response.sendRedirect("/showStudentInfo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/students/stu_add.jsp").forward(request, response);
    }

}
