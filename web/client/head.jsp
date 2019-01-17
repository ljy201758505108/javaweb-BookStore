<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>前台首页头</title>
  </head>
  
  <body style="text-align:center;">
    <h1>网上书店</h1>
    <br/>
    <div>
	    <a href="${pageContext.request.contextPath }/client/IndexServlet?method=getAll" target="body">首页</a>
	    <a href="${pageContext.request.contextPath }/client/listcart.jsp" target="body">查看购物车</a>
	    <a href="${pageContext.request.contextPath }/client/ClientListOrderServlet?userid=${user.id}" target="body">查看订单</a>
    </div>
	<div style="float:right;">

		<c:if test="${user!=null && user.root==false}">
			欢迎您：${user.username }
			<input type="button" value="注销" onclick="javascript:window.parent.location.href='${pageContext.request.contextPath }/client/LoginOutServlet'"><br>

		</c:if>

		<c:if test="${user!=null && user.root==true}">
			管理员您好：${user.username }
			<input type="button" value="注销" onclick="javascript:window.parent.location.href='${pageContext.request.contextPath }/client/LoginOutServlet'"><br>

		</c:if>

	</div>

  </body>
</html>
