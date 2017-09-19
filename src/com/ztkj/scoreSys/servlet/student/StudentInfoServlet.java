package com.ztkj.scoreSys.servlet.student;

import com.ztkj.scoreSys.dao.IStudentDao;
import com.ztkj.scoreSys.dao.impl.StudentDaoImpl;
import com.ztkj.scoreSys.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 处理学生信息Servlet
 */
public class StudentInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("进入--StudentInfoServlet");
        IStudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.getAllStus();
        for (Student s : studentList) {
            System.out.println(s.toString());
        }
        // 添加学生列表
        request.setAttribute("studentList", studentList);
        System.out.println("跳转--stu_list.html");
        request.getRequestDispatcher("WEB-INF/views/students/stu_list.jsp").forward(request, response);
    }
}
