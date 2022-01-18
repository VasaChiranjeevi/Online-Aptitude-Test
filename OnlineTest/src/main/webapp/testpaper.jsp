<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oat.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> TEST</title>
</head>
<body>
<c:forEach var="question" items="${al}">
${al.question}
</c:forEach>

</body>
</html>