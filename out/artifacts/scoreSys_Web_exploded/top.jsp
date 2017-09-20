<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ztkj.scoreSys.model.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>
<body style="background:url(${pageContext.request.contextPath}/images/topbg.gif) repeat-x;">

    <div class="topleft"><a href="${pageContext.request.contextPath}/main.jsp" target="_parent">
    <img src="${pageContext.request.contextPath}/images/logo.jpg"  title="系统首页" /></a></div>
        
            
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.request.contextPath}/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath}/login.jsp" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>
    	<%
    		// 获取登录用户的角色
    		Object roleObj = session.getAttribute("loginRole");
    		if (roleObj != null) { // 如果有用户登录
    			String role = roleObj.toString(); 
    			if ("1".equals(role)) {  // 老师登录
    				// 获取登录老师的信息
    				Object teacherObj = session.getAttribute("loginTeacher");
    				Teacher teacher = (Teacher)teacherObj;
    	%>
    			教师：<%=teacher.getTname() %>
    	<%			
    			} else if ("2".equals(role)) {  // 学生登录
    				// 获取登录学生的信息
    				Object stuObj = session.getAttribute("loginStu");
    				Student stu = (Student)stuObj;
    	%>
    			学生：<%=stu.getStuname() %>
    	<%		
    			}
    		} else {
    	%>
    			无用户登录
    	<%		
    		}
    	%>
    </span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>

</body>
</html>