<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户列表</title>
  </head>
  <body>
    <table width="80%" align="center">
    	<tr>
    		<td>编号</td>
    		<td>姓名</td>
    		<td>年龄</td>
    		<td>操作&nbsp;&nbsp;<a href="user/create.do?type=1">新增</a></td>
    	</tr>
    	<c:forEach items="${list }" var="bean">
	    	<tr>
	    		<td>${bean.id }</td>
	    		<td>${bean.name }</td>
	    		<td>${bean.age }</td>
	    		<td>
	    			<a href="user/${bean.id}/edit.do?type=2">编辑</a>
	    			<a href="user/${bean.id}/delete.do">删除</a>
	    		</td>
	    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
