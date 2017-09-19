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
	String strId = request.getParameter("id");
	int id = 1;
	if (strId != null && !"".equals(strId)) {
		id = Integer.parseInt(strId);
	}
	
	Classes cl = new Classes(clno, clname, insititue);
	cl.setId(id);
	
	IClassesDao clDao = new ClassesDaoImpl();
	boolean flag = clDao.updateClasses(cl);
	if (flag) {
		request.getRequestDispatcher("/classes/classes_list.jsp").forward(request, response);
	} else {
		request.setAttribute("upClTips", "修改班级失败");
		request.getRequestDispatcher("/classes/classes_update.jsp?id="+id).forward(request, response);
	}
%>