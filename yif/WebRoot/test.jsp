<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div class="action">
   <form action="<%=basePath%>shop/addshop.do" method="post">
   用户名：<input type="text" name="username" />
   密码：<input type="text" name="password" />
   <table>
   <tr><td><input type="text" name="phone" id="phone" /></td><td><input type="text" name="email" id="email" /></td><td><input type="text" name="name" id="name" /></td></tr>
   <tr><td><input type="text" name="phone" id="phone" /></td><td><input type="text" name="email" id="email" /></td><td><input type="text" name="name" id="name" /></td></tr>
   <tr><td><input type="text" name="phone" id="phone" /></td><td><input type="text" name="email"  id="email" /></td><td><input type="text" name="name" id="name" /></td></tr>
  
   <tr><td collspan="3"><input type="submit" value="测试" /></td></tr>
   </table>
   </form>
   </div>
  </body>
</html>
