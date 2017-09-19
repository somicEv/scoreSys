<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ztkj.scoreSys.dao.*" %>
<%@ page import="com.ztkj.scoreSys.dao.impl.*" %> 
<%@ page import="com.ztkj.scoreSys.model.*" %>    
<%
	request.setCharacterEncoding("UTF-8");
	String clno = request.getParameter("clno");
	String clname = request.getParameter("clname");
	String insititue = request.getParameter("insititue");
	
	Classes cl = new Classes(clno, clname, insititue);
	
	IClassesDao clDao = new ClassesDaoImpl();
	boolean flag = clDao.addClasses(cl);
	if (flag) {
		request.getRequestDispatcher("/classes/classes_list.jsp").forward(request, response);
	} else {
		request.setAttribute("addClTips", "添加班级失败");
		request.getRequestDispatcher("/classes/classes_add.jsp").forward(request, response);
	}
%>