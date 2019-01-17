<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>注册表单</title>
  </head>
  <title>后台左侧导航</title>
  <body style="text-align:center;">
  	<form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post">
		<input type="radio" name="root" value="Y">管理员<br>
		<input type="radio" name="root" value="N" checked>普通用户<br>

		用户名：<input type="text" name="username"><br/>
    	密码：<input type="password" name="password"><br/>
    	电话：<input type="text" name="phone"><br/>
    	手机：<input type="text" name="cellphone"><br/>
    	邮箱：<input type="text" name="email"><br/>
    	住址：<input type="text" name="address"><br/>
		注册：<input type="submit" value="提交">
    </form>
  </body>
</html>
