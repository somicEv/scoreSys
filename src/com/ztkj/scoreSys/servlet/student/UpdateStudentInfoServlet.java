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

public class UpdateStudentInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String stuno = request.getParameter("stuno");
        String stuname = request.getParameter("stuname");
        String spwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        Student student = new Student(Integer.parseInt(id), stuno, stuname, spwd, gender, birthday, null, null);
        StudentService studentService = new StudentService();
        boolean b = studentService.updateStudentInfo(student);
        if (!b){
            // 不成功
            response.sendRedirect("/updateStudentInfo");
        }
        response.sendRedirect("/showStudentInfo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询学生信息
        String studnetId = request.getParameter("studnetId");
        StudentService studentService = new StudentService();
        Student studentInfoById = studentService.getStudentInfoById(Integer.parseInt(studnetId));
        if (studentInfoById == null && studentInfoById.getCl() != null){
            request.getRequestDispatcher("WEB-INF/views/students/stu_list.jsp").forward(request,response);
        }
        // 查询班级信息
        ClassesService classesService = new ClassesService();
        Classes classes = classesService.selectClassInfo(studentInfoById.getCl().getId());
        studentInfoById.setCl(classes);
        request.setAttribute("studentInfo", studentInfoById);
        request.getRequestDispatcher("WEB-INF/views/students/stu_update.jsp").forward(request,response);
    }
}
