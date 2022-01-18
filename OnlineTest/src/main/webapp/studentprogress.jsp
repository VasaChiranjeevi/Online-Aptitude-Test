<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oat.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students Score</title>
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
<h3 align="right"><a href="adminhomepage.html">home page</a></h3>
<h1 style="text-align:center;">Student Result</h1>
<% ArrayList<OATBean> al=(ArrayList<OATBean>)session.getAttribute("OATal"); %>
<table align="center">
<tr align="center">
    <th>Student ID</th>
    <th>Name</th>
    <th>Score</th>
  </tr>
<form method="post" action="OATController">
<% for(OATBean bean:al){ %>
<tr align="center">
    <td><%= bean.getStudent_ID() %></td>
    <td><%= bean.getSusername() %></td>
    <td><%= bean.getCount() %></td>
</tr>
<%} %>
</table>
<br>
<fieldset>
<center>
<h3>To view Individual response enter Student ID</h3>
<br>
<input type="text" placeholder="Enter Student ID" name="Student_ID">
<br>
<br>
<td><button type="submit" name="view">View</button>
<br>
</center>
</fieldset>
</body>
</html>