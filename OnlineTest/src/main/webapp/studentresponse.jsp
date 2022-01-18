<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oat.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Response</title>
<style>
table 
{
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th 
{
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even)
{
  background-color: #dddddd;
}
</style>
</head>
<body>
<h1 align="center">Response Sheet</h1>
<% ArrayList<OATBean> all=(ArrayList<OATBean>)session.getAttribute("OATal"); %>
<fieldset>
<h3>Student ID:<%=session.getAttribute("Student_ID")%></h3>
<%OATBean bean1 = (OATBean)all.get(0);%>
<h3>Student Name:  <%=bean1.getSusername()%></h3>
</fieldset>
<br>
<br>
<table align="center">
<tr align="center">
	<th>Question ID</th>
    <th>Question</th>
    <th>Response</th>
    <th>Correct Answer</th>
  </tr>
<form method="post" action="OATController">
<% for(OATBean bean:all){ %>
<tr align="center">
	<td><%= bean.getquestion_ID() %></td>
    <td><%= bean.getQuestion() %></td>
    <td><%= bean.getresponse() %></td>
    <td><%= bean.getAnswer() %></td>
</tr>
<%} %>
</table>
<br>
<br>
<center>
<button type="submit" name="progress" formaction="OATController">back</button></h1>
</center>
</body>
</html>