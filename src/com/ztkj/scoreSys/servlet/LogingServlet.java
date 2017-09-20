package com.ztkj.scoreSys.servlet;

import com.ztkj.scoreSys.dao.IStudentDao;
import com.ztkj.scoreSys.dao.ITeacherDao;
import com.ztkj.scoreSys.dao.impl.StudentDaoImpl;
import com.ztkj.scoreSys.dao.impl.TeacherDaoImpl;
import com.ztkj.scoreSys.model.Student;
import com.ztkj.scoreSys.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("loginName");
        String pwd = request.getParameter("loginPwd");
        String role = request.getParameter("loginRole");
        System.out.println(userName);
        HttpSession session = request.getSession();
        Teacher teacher =  null;
        Student stu = null;
        if ("1".equals(role)) { // 教师角色登陆
            ITeacherDao teaDao = new TeacherDaoImpl();
            teacher = teaDao.login(userName,pwd);
            if (teacher != null) {
                //　存储登录成功的用户
                session.setAttribute("loginTeacher", teacher);
                System.out.println("教师登陆成功!");
            } else {
                System.out.println("教师登陆失败!");
            }
        } else if ("2".equals(role)) {// 学生角色登陆
            IStudentDao stuDao = new StudentDaoImpl();
            stu = stuDao.login(userName, pwd);
            if (stu != null) {
                //　存储登录成功的用户
                session.setAttribute("loginStu", stu);
                System.out.println("学生登陆成功!");
            } else {
                System.out.println("学生登陆失败!");
            }
        }

        session.setAttribute("loginRole", role);

        if (teacher == null && stu == null) { // 登录不成功
            request.setAttribute("loginTips", "登录失败,用户名或者密码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
