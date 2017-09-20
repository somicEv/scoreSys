<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<script type="text/javascript" src="../../../laydate/laydate.js"></script>
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
    <form action="/addStudentInfoServlet" method="post">
        <ul class="forminfo">
        <li><label>学号</label><input name="stuno" type="text" class="dfinput"/><i>标题不能超过30个字符</i></li>
        <li><label>姓名</label><input name="stuname" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
        <li><label>密码</label><input name="pwd" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
        <li><label>性别</label><cite><input name="gender" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input name="gender" type="radio" value="女" />女</cite></li>
        <li><label>班级</label>
                <div class="fleft">
                    <select name="classid" class="select2" style="width: 167px;">
                        <option value="1">软件一班</option>
                        <option value="2">软件二班</option>
                        <option value="3">软件三班</option>
                        <option value="4">软件四班</option>
                    </select>
                </div>
        </li>
        <li><label>出生年月</label>
            <input name="birthday" class="laydate-icon dfinput" id="demo" value="2017-9-14" style="height: 34px; line-height: 34px;">
        </li>
        <li><label>年龄</label>
            <input name="age" class="laydate-icon dfinput" id="demo" style="height: 34px; line-height: 34px;">
        </li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
    
    </div>

    <script type="text/javascript">
        !function(){
            laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
            laydate({elem: '#demo'});//绑定元素
        }();
    </script>
</body>

</html>
