<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HashMap<String, Object> data 
			= (HashMap<String, Object>) request.getAttribute("data");
		String html = data.toString();
		String title = data.get("title").toString();
	%>
	<%= html%>
	<h1><%= data.get("title") %></h1>
	<p><%= data.get("content") %></p>
	<a href="">목록</a>
</body>
</html>