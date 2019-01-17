<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>显示订单</title>
  </head>
  
  <body style="text-align:center;">
    <h2>订单列表</h2>
    <table width="60%" border="1" align="center" style="text-align: center;">
    	<tr>
    		<td>订单号</td>
    		<td>订单人</td>
    		<td>订单时间</td>
    		<td>订单总价</td>
    		<td>订单状态</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach var="order" items="${orders }">
    		<tr>
    			<td>${order.id }</td>
	    		<td>${order.user.username }</td>
	    		<td>${order.ordertime }</td>
	    		<td>${order.price }</td>
	    		<td>${order.state==true?'已发货':'未发货' }</td>
	    		<td>
	    			<a href="${pageContext.request.contextPath }/manager/OrderDetailServlet?orderid=${order.id}">查看明细</a>
					<%--可以修改的只有一种情况，就是未发货state==false，并且用户未取消view==true(目前只实现了删除功能)--%>
	    			<a href="#">${order.state==false && order.view==true?'修改':''}</a>
					<%--在发货并且用户删除的情况下，才真正从数据库删除--%>
					<a href="${pageContext.request.contextPath }/manager/delectOrderServlet?orderid=${order.id}&state=${order.state}">${order.state=true&&order.view==false?'删除':''}</a>

				</td>
    		</tr>
    	</c:forEach>
    	
	</table>
  </body>
</html>
