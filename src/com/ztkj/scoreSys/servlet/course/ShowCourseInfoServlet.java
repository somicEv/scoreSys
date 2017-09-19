package com.ztkj.scoreSys.servlet.course;

import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowCourseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseService courseService = new CourseService();
        List<Course> courseList = courseService.selectCourseList();
        // TODO 未解决 courseList 可能为空的情况
        request.setAttribute("courseList", courseList);
        request.getRequestDispatcher("WEB-INF/views/course/course_list.jsp").forward(request,response);
    }
}
