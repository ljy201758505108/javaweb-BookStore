<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/16
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>前台首页</title>
</head>
<script>
    //跳出当前frame
    function windowonload() {
        if(top.location != self.location){
            top.location = self.location;
        }
    }
    windowonload();
</script>


<frameset rows="25%,*">
    <frame src="${pageContext.request.contextPath }/client/head.jsp" name="clienthead">
    <frame src="${pageContext.request.contextPath }/client/IndexServlet?method=getAll" name="body">
</frameset>

</html>