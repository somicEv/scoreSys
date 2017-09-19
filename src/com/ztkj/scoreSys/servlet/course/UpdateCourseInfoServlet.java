package com.ztkj.scoreSys.servlet.course;

import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.model.Teacher;
import com.ztkj.scoreSys.service.CourseService;
import com.ztkj.scoreSys.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCourseInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询相应的教师
        String tid = request.getParameter("tid");
        TeacherService teacherService = new TeacherService();
        Teacher teacherInfo = teacherService.getTeacherInfo(Integer.parseInt(tid));
        String cname = request.getParameter("cname");
        String courseId = request.getParameter("courseId");
        Course course = new Course();
        course.setCname(cname);
        course.setId(Integer.parseInt(courseId));
        course.setTeacher(teacherInfo);
        CourseService courseService = new CourseService();
        boolean b = courseService.updateCourseInfo(course);
        if (!b){
            // 不成功
            response.sendRedirect("/updateCourseInfoServlet");
        }
        response.sendRedirect("/showCourseInfoServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        CourseService courseService = new CourseService();
        Course course = courseService.selectCourseInfo(Integer.parseInt(courseId));
        request.setAttribute("courseInfo",course);
        request.getRequestDispatcher("/WEB-INF/views/course/course_update.jsp").forward(request, response);
    }
}
