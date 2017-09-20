<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
    <c:if test="${sessionScope.loginRole == '1'}">
	<div class="lefttop"><span></span>功能列表</div>
    <dl class="leftmenu">
    <dd>
        <div class="title">
        <span><img src="${pageContext.request.contextPath}/images/leftico01.png" /></span>班级管理
        </div>
            <ul class="menuson">
            <li class="active"><cite></cite><a href="/showClassInfo" target="rightFrame">班级列表</a><i></i></li>
            <li><cite></cite><a href="/addClassInfoServlet" target="rightFrame">添加班级</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title">
        <span><img src="images/leftico02.png" /></span>学员管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="/showStudentInfo" target="rightFrame">学员列表</a><i></i></li>
            <li><cite></cite><a href="/addStudentInfoServlet" target="rightFrame">添加学员</a><i></i></li>
        </ul>
    </dd> 
    <dd>
        <div class="title">
        <span><img src="images/leftico04.png" /></span>课程管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="/showTeacherInfo" target="rightFrame">教师列表</a><i></i></li>
            <li><cite></cite><a href="/addTeacherInfo" target="rightFrame">添加教师</a><i></i></li>
            <li><cite></cite><a href="/showCourseInfoServlet" target="rightFrame">课程列表</a><i></i></li>
            <li><cite></cite><a href="/addCourseInfoServlet" target="rightFrame">添加课程</a><i></i></li>
        </ul>
    </dd> 
    <dd><
        div class="title"><span><img src="images/leftico03.png" /></span>成绩管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="/showScoreInfoServlet" target="rightFrame">成绩列表</a><i></i></li>
            <li><cite></cite><a href="/addScoreInfoServlet" target="rightFrame">添加成绩</a><i></i></li>
        </ul>
    </dd>  
    </dl>
    </c:if>
    <c:if test="${sessionScope.loginRole == '2'}">
        <div class="lefttop"><span></span>功能列表</div>
        <dl class="leftmenu">
            <dd>
                <div class="title">
                    <span><img src="${pageContext.request.contextPath}/images/leftico01.png" /></span>班级管理
                </div>
                <ul class="menuson">
                    <li class="active"><cite></cite><a href="/showClassInfo" target="rightFrame">班级列表</a><i></i></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico02.png" /></span>学员管理
                </div>
                <ul class="menuson">
                    <li><cite></cite><a href="/showStudentInfo" target="rightFrame">学员列表</a><i></i></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico04.png" /></span>课程管理
                </div>
                <ul class="menuson">
                    <li><cite></cite><a href="/showCourseInfoServlet" target="rightFrame">课程列表</a><i></i></li>
                </ul>
            </dd>
            <dd><div class="title"><span><img src="images/leftico03.png" /></span>成绩管理</div>
                <ul class="menuson">
                    <li><cite></cite><a href="/showScoreInfoServlet" target="rightFrame">成绩列表</a><i></i></li>
                </ul>
            </dd>
        </dl>
    </c:if>
</body>
</html>