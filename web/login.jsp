<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="HEIGHT: 100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学工管理信息系统</title>
<STYLE type=text/css>
#LoginBoxOuter {
	BORDER-RIGHT: #7fafe0 1px solid; BORDER-TOP: #7fafe0 1px solid; BORDER-LEFT: #7fafe0 1px solid; WIDTH: 570px; BORDER-BOTTOM: #7fafe0 1px solid; HEIGHT: 330px
}
#LoginBoxLeft {
	FILTER: Alpha(Opacity=100, FinishOpacity=40, Style=1, StartX=0, StartY=0, FinishX=50, FinishY=100); WIDTH: 25%; BACKGROUND-COLOR: #76aadf
}
#LoginBoxRight {
	WIDTH: 75%
}
#LoginBoxAppName {
	FONT-WEIGHT: bold; FONT-SIZE: 13pt; PADDING-BOTTOM: 10px; WIDTH: 80%; COLOR: #7397e1; FONT-FAMILY: Verdana,黑体,Arial; TEXT-ALIGN: center
}
#LoginBoxFieldset {
	WIDTH: 80%
}
#LoginBoxLegend {
	FONT-SIZE: 9pt; COLOR: #ce7271
}
#LoginBoxCopyright {
	FONT-SIZE: 8pt; WIDTH: 80%; COLOR: #a4a4a4; PADDING-TOP: 2px; FONT-FAMILY: arial; TEXT-ALIGN: right
}
#LoginBoxFooter {
	PADDING-RIGHT: 26px; BORDER-TOP: #6699cc 2px solid; WIDTH: 100%; HEIGHT: 40px; BACKGROUND-COLOR: #e8edf4
}
#LoginBoxResultMessage {
	FONT-WEIGHT: bold; FONT-SIZE: 9pt; COLOR: red; FONT-FAMILY: Verdana,宋体,Arial
}
.TextBox {
	BORDER-RIGHT: #b2c4db 1px solid; BORDER-TOP: #b2c4db 1px solid; BORDER-LEFT: #b2c4db 1px solid; COLOR: #000000; WORD-BREAK: break-all; BORDER-BOTTOM: #b2c4db 1px solid; WHITE-SPACE: normal; HEIGHT: 20px; BACKGROUND-COLOR: #ffffff
}
.Button {
	BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: bold; BORDER-LEFT-WIDTH: 0px; FONT-SIZE: 9pt; BACKGROUND-IMAGE: url(images/buttonBg.gif); BORDER-BOTTOM-WIDTH: 0px; WIDTH: 70px; COLOR: #ffffff; HEIGHT: 20px; BORDER-RIGHT-WIDTH: 0px
}
.Button100 {
	BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: bold; BORDER-LEFT-WIDTH: 0px; BACKGROUND-IMAGE: url(/images/buttonBg100.gif); BORDER-BOTTOM-WIDTH: 0px; WIDTH: 100px; COLOR: #ffffff; HEIGHT: 20px; BORDER-RIGHT-WIDTH: 0px
}
</STYLE>

<SCRIPT language=javascript>
        //登录客户端验证
        function CheckLogin()
        {
            var msg = null;

            if(document.getElementById("loginName").value == "")
            {
                document.getElementById("loginName").focus();
                msg = "请输入用户名";
            }
            else if (document.getElementById("loginPwd").value == "")
            {
                document.getElementById("loginPwd").focus();
                msg = "请输入登录密码";
            }

            if (msg != null)
            {
                alert(msg);
                return false;
            }else{
                   return true;
            }
     }
        
    window.onload=function(){
		<%
			// 获取传递回来的提示信息
			Object obj = request.getAttribute("loginTips");
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
</SCRIPT>
</head>
<BODY style="OVERFLOW-Y: auto; OVERFLOW-X: auto; MARGIN: 0px; HEIGHT: 100%"
bgColor=#0E5981>
<TABLE style="WIDTH: 100%; HEIGHT: 100%" cellSpacing=0 cellPadding=0 border=0>
  <TBODY>
  <TR>
    <TD
    style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; WIDTH: 100%; PADDING-TOP: 0px; HEIGHT: 100%"
    vAlign=top align=left>
      <TABLE style="WIDTH: 100%; HEIGHT: 100%" cellSpacing=0 cellPadding=0>
        <TBODY>
        <TR>
          <TD id=PageGlobalContainer
          style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle; PADDING-TOP: 0px; HEIGHT: 100%"><!-- === * Begin Content * === -->
            <FORM id=Form1 name=Form1 action="/loginServlet"
            method="post">
            <TABLE height="100%" width="100%" align=center border=0>
              <TBODY>
              <TR>
                <TD vAlign=center align=middle>
                  <TABLE height=391 width=800 border=0>
                    <TBODY>
                    <TR>
                      <TD
                      style="BACKGROUND: url(${pageContext.request.contextPath}/images/swloginbg.jpg) no-repeat"
                      vAlign=center
                        align=right><BR><BR><BR><BR><BR><BR><BR><BR>
                       
                        <TABLE height=151 width=401 border=0>
                          <TBODY>
                          <TR>
                            <TD width="20%">&nbsp;</TD>
                            <TD vAlign=center width=250>
                              <TABLE width="100%" border=0>
                                <TBODY>
                                <TR>
                                <TD vAlign=bottom height=50>&nbsp;</TD></TR>
                                <TR>
                                <TD>用户名</TD>
                                <TD><INPUT id=loginName
                                style="BORDER-RIGHT: #2a739c 1px solid; BORDER-TOP: #2a739c 1px solid; FONT-WEIGHT: bold; FONT-SIZE: 16px; BORDER-LEFT: #2a739c 1px solid; WIDTH: 180px; BORDER-BOTTOM: #2a739c 1px solid; FONT-FAMILY: arial; HEIGHT: 23px"
                                name=loginName></TD></TR>
                                <TR>
                                <TD>密&nbsp;&nbsp;码</TD>
                                <TD><INPUT id=loginPwd
                                style="BORDER-RIGHT: #2a739c 1px solid; BORDER-TOP: #2a739c 1px solid; FONT-SIZE: 16px; BORDER-LEFT: #2a739c 1px solid; WIDTH: 180px; BORDER-BOTTOM: #2a739c 1px solid; HEIGHT: 23px"
                                type=password name=loginPwd></TD></TR>
                                <TR>
                                <TD>角&nbsp;&nbsp;色</TD>
                                <TD><select class="select2" name="loginRole">
                                    <option value="1">教师</option>
                                    <option value="2">学生</option>
                                </select></TD></TR>
                                <TR>
                                <TD>&nbsp;&nbsp;</TD>
                                <TD vAlign=bottom height=35><INPUT id=butLogin style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/images/sw/B_Button.gif); BORDER-BOTTOM-WIDTH: 0px; WIDTH: 70px; HEIGHT: 25px; BACKGROUND-COLOR: #69aecb; BORDER-RIGHT-WIDTH: 0px" accessKey=l onclick="return CheckLogin();" type=submit value=登录 name=butLogin>&nbsp;<INPUT id=butReset style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/images/sw/B_Button.gif); BORDER-BOTTOM-WIDTH: 0px; WIDTH: 70px; HEIGHT: 25px; BACKGROUND-COLOR: #69aecb; BORDER-RIGHT-WIDTH: 0px" accessKey=r onclick=ResetPage(); type="reset" value=重置 name=butReset></TD></TR>
                                <TR>
                                <TD>&nbsp;&nbsp;</TD>
                                <TD height=20><SPAN
                                id=LoginBoxResultMessage></SPAN></TD></TR></TBODY></TABLE>

                            <TD
                    width=50>&nbsp;</TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
            <SCRIPT language=javascript>document.getElementById('loginName').focus();</SCRIPT>
            </FORM><!-- === * End Content * ==== --></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>

<!-- 2014/8/22 10:14:39 --><!-- PAGE GENERATED BY MINGTHINK SOFTWARE  --><!-- SOLUTION SUPPORT FROM MINGTHINK INFORMATION TECHNOLOGY.(MINGTHINK.com) --></BODY>
</html>