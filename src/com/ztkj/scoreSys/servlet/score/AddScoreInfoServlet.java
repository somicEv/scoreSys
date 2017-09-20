package com.ztkj.scoreSys.servlet.score;

import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.model.Student;
import com.ztkj.scoreSys.service.CourseService;
import com.ztkj.scoreSys.service.ScoreService;
import com.ztkj.scoreSys.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddScoreInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        double score = Double.parseDouble(request.getParameter("score"));
        ScoreService scoreService = new ScoreService();
        boolean b = scoreService.addScoreInfo(score, studentId, courseId);
        if (!b){
            // 不成功
            response.sendRedirect("/addScoreInfoServlet");
        }
        response.sendRedirect("/showScoreInfoServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询学生列表
        StudentService studentService = new StudentService();
        List<Student> allStudentInfo = studentService.getAllStudentInfo();
        request.setAttribute("studentList", allStudentInfo);
        // 查询课程列表
        CourseService courseService = new CourseService();
        List<Course> courseList = courseService.selectCourseList();
        request.setAttribute("courseList", courseList);
        request.getRequestDispatcher("WEB-INF/views/score/score_add.jsp").forward(request, response);
    }
}
