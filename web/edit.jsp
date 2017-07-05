<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><c:if test="${param.type eq '1'}">新增</c:if><c:if test="${param.type eq '2'}">编辑</c:if>页</title>
    <script type="text/javascript" src="/js/jquery-1.9.1.js"></script>
    <script type="text/javascript">
    	$(function(){
    		if("${param.type}" == 2)
    			$("#frm").attr("action","/user/update.do");
    	});
    </script>
  </head>
  
  <body>
    <form id="frm" action="/user/save.do" method="post">
      <c:if test="${param.type eq '2'}"><input type="hidden" name="user.id" value="${user.id }"/></c:if>
    	<table>
    		<tr>
    			<td>姓名：</td>
    			<td><input type="text" id="name" name="user.name" value="${user.name }"/></td>
    		</tr>
    		<tr>
    			<td>年龄：</td>
    			<td><input type="text" id="age" name="user.age" value="${user.age }"/></td>
    		</tr>
    	</table>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
