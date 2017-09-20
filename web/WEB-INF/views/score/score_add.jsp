<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../../../css/style.css" rel="stylesheet" type="text/css" />
<link href="../../../css/select.css" rel="stylesheet" type="text/css" />
<link href="../../../css/index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../../../js/jquery.js"></script>
<script type="text/javascript" src="../../../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../../../js/select-ui.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(e) {
        $(".select2").uedSelect({
            width : 167
        });
    });


</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>

    <div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="" method="post">
    <ul class="forminfo">
    <li><label>姓名</label>
        <div class="">
            <select name="studentId" class="" style="width: 167px; opacity: 100;">
                <c:forEach var="student" items="${requestScope.studentList}">
                    <option value="${student.id}">${student.stuname}</option>
                </c:forEach>
            </select>
        </div>
    </li>
    <li><label>课程</label>
        <div class="">
            <select name="courseId" class="" style="width: 167px; opacity: 100;" >
                <c:forEach var="course" items="${requestScope.courseList}">
                    <option value="${course.id}">${course.cname}</option>
                </c:forEach>
            </select>
        </div>
    </li>
    <li><label>成绩</label><input name="score" type="text" class="dfinput" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    </div>
</body>

</html>
