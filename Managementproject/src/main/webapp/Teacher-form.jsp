<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="insert" method="get">
<table>  
<tr><td>Username:</td><td><input type="text" name="username"/></td></tr>  
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>   
<tr><td>Subject:</td><td><input type="text" name="subject"/></td></tr> 
<tr><td>Std:</td><td><input type="number" name="std"/></td></tr>   
<tr><td>TeacherId:</td><td><input type="number" name="teacherID"/></td></tr>     
<tr><td><a href="<%=request.getContextPath()%>/insert" class="btn btn-success"> Save</a> </td></tr>
</table>  
</form>

</body>
</html>