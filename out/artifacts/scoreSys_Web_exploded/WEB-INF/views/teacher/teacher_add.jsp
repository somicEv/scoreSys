<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../../../css/style.css" rel="stylesheet" type="text/css" />
<%--<link href="../../../css/select.css" rel="stylesheet" type="text/css" />--%>
<link href="../../../css/index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../../../js/jquery.js"></script>
<script type="text/javascript">

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
        <form action="/addTeacherInfo" method="post">
            <ul class="forminfo">
                <li><label>教师名</label><input name="teacherName" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
                <li><label>密码</label><input name="teacherPassword" type="password" class="dfinput" /><i>标题不能超过30个字符</i></li>
                <li><label>所属院校</label>
                    <div class="">
                        <select name="" class="" style="width: 167px; opacity: 100;" >
                            <option value="软件学院">软件学院</option>
                            <option value="软件学院">软件学院</option>
                            <option value="软件学院">软件学院</option>
                        </select>
                    </div>
                </li>
                <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
            </ul>
        </form>
    </div>
</body>
</html>
