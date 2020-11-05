<%@page import="com.cdac.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{  background: url("image2.jpg");}
</style>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<table align="center" >
		<tr><td>&nbsp;&nbsp;</td></tr>
		<tr>
			<td style="color:white;"> Welcome <%=(session.getAttribute("user")!=null) ? ((User)session.getAttribute("user")).getUserName() : "!!!!!!!!" %> </td>
		</tr>
		<tr>
			<td> <a href="prep_question_add_form.htm" style="color:white;" >Submit Your Question</a> </td>
		</tr>
		<tr>
			<td> <a href="question_list.htm" style="color:white;" >Find Your Solutions Here</a> </td>
		</tr>
		<tr>
			<td> <a href="index.jsp" style="color:white;" >Logout</a> </td>
		</tr>
	</table>
</body>
</html>