package com.ztkj.scoreSys.servlet.course;

import com.ztkj.scoreSys.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCourseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        CourseService courseService = new CourseService();
        boolean b = courseService.deleteCourseInfo(Integer.parseInt(courseId));
        if (!b){
            // 不成功
            response.sendRedirect("/showCourseInfoServlet");
        }
        response.sendRedirect("/showCourseInfoServlet");
    }
}
