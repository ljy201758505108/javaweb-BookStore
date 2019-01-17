<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>后台首页</title>
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

  <frameset rows="15%,*">
  	<frame src="${pageContext.request.contextPath }/manager/head.jsp" name="managerhead">
  	<frameset cols="15%,*">
  		<frame src="${pageContext.request.contextPath }/manager/left.jsp" name="left">
  		<frame src="${pageContext.request.contextPath }/manager/right.jsp" name="right">
  	</frameset>
  </frameset>
</html>
