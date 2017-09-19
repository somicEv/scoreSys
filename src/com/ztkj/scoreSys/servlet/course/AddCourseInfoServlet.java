package com.ztkj.scoreSys.servlet.course;

import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCourseInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cname = request.getParameter("cname");
        String tid = request.getParameter("tid");
        Course course = new Course();
        course.setCname(cname);
        CourseService courseService = new CourseService();
        boolean b = courseService.addCourseInfo(course, Integer.parseInt(tid));
        if (!b){
            // 不成功
            request.getRequestDispatcher("WEB-INF/views/course/course_add.jsp").forward(request, response);
        }
        response.sendRedirect("/showCourseInfoServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/course/course_add.jsp").forward(request, response);
    }
}
