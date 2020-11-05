<%@page import="com.cdac.dto.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	
	<table align="center" >
		<% 
		List<Question> qlist = (List<Question>)request.getAttribute("queList");
		for(Question que : qlist){
		%>
		
		
		<tr>
			<td>
				<%=que.getSubject()%>
			</td>
			<td>
				<%=que.getQuestion()%>
			</td>
			
			<td>
				<a href="question_delete.htm?queId=<%=que.getQueId()%>" style="margin-right:10px;margin-left:10px;border:5px solid black;">DeleteQuestion</a> 
			</td>
			<td>
				<a href="question_update_form.htm?queId=<%=que.getQueId()%>">UpdateQuestion</a>
			</td>
		</tr>
		<% } %>
		<tr>
			<td>
				<a href="home.jsp" >Back</a>
			</td>
			<td>
				
			</td>
		</tr>
	</table>
	
</body>
</html>