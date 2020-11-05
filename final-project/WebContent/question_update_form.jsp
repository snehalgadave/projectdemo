<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Question Form</title>
</head>
<body>
	<spr:form action="question_update.htm" method="post" commandName="question" >
	<table align="center" >
		<tr>
			<td>
				
			</td>
			<td>
				<spr:hidden path="queId"/>
			</td>
		</tr>
		<tr>
			<td>
				Subject :
			</td>
			<td>
				<spr:select path="subject">
			<spr:option value="java">Java</spr:option>
		</spr:select>
				
			</td>
		</tr>
		<tr>
			<td>
				Question:
			</td>
			<td>
				<spr:select path="question">
			<spr:option value="1.What is Java?">1.What is Java?</spr:option>
			<spr:option value="2.What are the features of Java Programming language">2.What are the features of Java Programming language</spr:option>
			<spr:option value="3.What is the difference between JDK, JRE, and JVM?">3.What is the difference between JDK, JRE, and JVM?</spr:option>
		</spr:select>
			</td>
		</tr>
		
		<tr>
			<td>
				<a href="question_list.htm" >Back</a>
			</td>
			<td>
				<input type="submit" value="UpdateQuestion" >
			</td>
		</tr>
	</table>
	</spr:form>
</body>
</html>