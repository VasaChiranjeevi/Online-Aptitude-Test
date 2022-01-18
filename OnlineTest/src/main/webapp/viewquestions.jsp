<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oat.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align=center>
<h3 align="right"><a href="adminhomepage.html">home page</a></h3>
<h3 style="text-align:center;">SAVED QUESTIONS</h3>
<form method="post" action="OATController">
<% ArrayList<OATBean> al=(ArrayList<OATBean>)session.getAttribute("OATal"); %>
<table border="1" align=center>
<% for(OATBean bean:al){ %>
<tr>
<td align=left><input type="checkbox"name="questions" value="<%= bean.getQuestion() %>"><%= bean.getQuestion() %></td>
</tr>
<%} %>
</table>
<td><center><button type="submit" name="create">Create QuestionPaper</button></center></td>
</form>
</body>
</html>