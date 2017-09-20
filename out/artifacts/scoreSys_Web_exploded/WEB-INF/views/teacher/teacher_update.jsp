<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select2").uedSelect({
                width: 167
            });
        });

        window.onload = function () {
            <%
                // 获取传递回来的提示信息
                Object obj = request.getAttribute("upClTips");
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
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">
    <div class="formtitle"><span>基本信息</span></div>
    <form action="${pageContext.request.contextPath}/updateTeacher.html" method="post">
        <ul class="forminfo">
            <input type="hidden" value="${requestScope.teacherInfo.id}" name="id"/>
            <li><label>教师姓名</label><input name="tname" type="text" class="dfinput"
                                          value="${requestScope.teacherInfo.tname}"/>
            </li>
            <li><label>密码</label><input name="tpwd" type="text" class="dfinput"
                                        value="${requestScope.teacherInfo.tpwd}"/>
            </li>
            <li><label>所属院校</label>
                <div class="fleft">
                    <select name="collage" class="select2" style="width: 167px;">
                        <option
                                <c:if test="${requestScope.teacherInfo.collage} == '信息工程学院' ">
                                    selected="selected"
                                </c:if>
                        >信息工程学院
                        </option>
                        <option
                                <c:if test="${requestScope.teacherInfo.collage} == '材料与化学学院' ">
                                    selected="selected"
                                </c:if>
                        >材料与化学学院
                        </option>
                        <option
                                <c:if test="${requestScope.teacherInfo.collage} == '外语学院' ">
                                    selected="selected"
                                </c:if>
                        >外语学院
                        </option>
                        <option
                                <c:if test="${requestScope.teacherInfo.collage} == '地质学院' ">
                                    selected="selected"
                                </c:if>
                        >地质学院
                        </option>
                    </select>
                </div>
            </li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>
        </ul>
    </form>

</div>

</body>
</html>