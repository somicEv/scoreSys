<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });

        window.onload=function(){
            <%
                // 获取传递回来的提示信息
                Object obj = request.getAttribute("tips");
                // 如果有提示信息
                if (obj !=null && !"".equals(obj)) {
                    // 将提示信息转换为字符串
                    String str = obj.toString();
            %>
            alert("<%=str %>");
            <%
                }
            %>
        }
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">数据表</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click"><span><img src="${pageContext.request.contextPath}/images/t01.png" /></span>添加</li>
            <li class="click"><span><img src="${pageContext.request.contextPath}/images/t02.png" /></span>修改</li>
            <li><span><img src="${pageContext.request.contextPath}/images/t03.png" /></span>删除</li>
            <li><span><img src="${pageContext.request.contextPath}/images/t04.png" /></span>统计</li>
        </ul>
        <ul class="toolbar1">
            <li><span><img src="${pageContext.request.contextPath}/images/t05.png" /></span>设置</li>
        </ul>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>编号<i class="sort"><img src="${pageContext.request.contextPath}/images/px.gif" /></i></th>
            <th>课程名</th>
            <th>任课教师</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="courseInfo" items="${requestScope.courseList}">
                <tr>
                    <td><input name="sign" type="checkbox" value="" /></td>
                    <td>${courseInfo.id}</td>
                    <td>${courseInfo.cname}</td>
                    <td>${courseInfo.teacher.tname}</td>
                    <td>
                        <a href="/updateCourseInfoServlet?courseId=${courseInfo.id}" class="tablelink">修改</a>
                        <a href="#" class="tablelink"> 删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">1</a></li>
            <li class="paginItem current"><a href="javascript:;">2</a></li>
            <li class="paginItem"><a href="javascript:;">3</a></li>
            <li class="paginItem"><a href="javascript:;">4</a></li>
            <li class="paginItem"><a href="javascript:;">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;">10</a></li>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>


    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="${pageContext.request.contextPath}/images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>