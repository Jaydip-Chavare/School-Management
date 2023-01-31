
<%@page import="schoolmanagemengt.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Here</title>
</head>
<body bgcolor="silver">
<style type="text/css">
input{
 border-width:4px;
 border-style:outset;
  border-radius:7px;
 background-color:bisque;

}
div{
 width:200px;
border:7px solid black;
padding:50px;
margin:20px;
background-color:plum;
}
font{
font-size:20px;
}
</style>
<%
String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
	EntityManager em = emf.createEntityManager();
	Student s = em.find(Student.class, id1);
%>
<center>
<div>
	<form action="updated" method="post">
	<pre>
 <font>Update value</font><br><br>
<b>Id:</b>    <input type="text" value="<%=s.getId()%>" name="id"><br><br>
<b>Name:</b>  <input type="text" value="<%=s.getName()%>" name="name"><br><br>
<b>Stream:</b><input type="text" value="<%=s.getStream()%>" name="stream"><br><br>
<b>Fees:</b>  <input type="text" value="<%=s.getFees()%>"name="fees"><br><br>
	<input type="submit">
		</pre>
	</form>
	
	</div>
	</center>
	




</body>
</html>