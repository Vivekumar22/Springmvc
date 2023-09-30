<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   THIS IS THE JSP PAGE <br>
   <%= request.getAttribute("s1") %>
   <br/>
   the string value is ${s1}
   <br/>
   List value is  ${List}
   <table>
   <tr>
   		<th>Stu_id </th>
   		<th>Stu_name </th>
   		<th>Edit</th>	
   		<th>Delete</th>
   </tr>
   <c:forEach var="stu" items="${List}">
   <tr>
   		<td>${stu.getId()} </td>
   		<td>${stu.getName()} </td>
   		<td><a href="/Springmvc/update/${stu.getId()}">Edit</a></td>
   		<td><a href="/Springmvc/delete/${stu.getId()}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   
   <br/>
   <a href="/Springmvc/add">Add Student</a>
</body>
</html>