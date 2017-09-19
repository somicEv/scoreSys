<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.ztkj.scoreSys.dao.*" %>
<%@ page import="com.ztkj.scoreSys.dao.impl.*" %>
<%@ page import="com.ztkj.scoreSys.model.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("loginName");
	String pwd = request.getParameter("loginPwd");
	String role = request.getParameter("loginRole");
	System.out.println(userName);
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
%>    