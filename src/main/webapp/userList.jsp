<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>
<%
List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) request.getAttribute("list");
String html ="";
for(int i=0;i<list.size();i++){
	html +="<a href='insert.jsp?userNo="+list.get(i).get("num")+"'>"+list.get(i).get("id") + "<br>";
}
%>
<%= html %>
</body>
</html>