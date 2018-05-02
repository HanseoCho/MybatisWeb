<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) request.getAttribute("list");
String html ="";
for(int i=0;i<list.size();i++){
	html +="<a href='BoardView?boardNo="+list.get(i).get("boardNo")+"&regUser="+list.get(i).get("regUser")+"'>"+list.get(i).get("title") + "<br>";
}
%>
<%= html %>
</body>
</html>