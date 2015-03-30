<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dbasnjdbc.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello User</h1>
<% 
    
 	UserManager um = new UserManager();
    
    //add user
	user u = new user();
	u.setUsername("rohit");
	u.setPassword("r123");
	u.setFirstName("Rohit");
	u.setLastName("Aswani");
	u.setEmail("rohit@gmail.com");
	u.setDateOfBirth("1990-05-06");
	um.createUser(u);
	
	
	/*
	//read all user
	List<user> u1 = um.readAllUsers();
	
	for(int i=0; i<u1.size(); i++)
	{
		System.out.println(u1.get(i).getEmail());
	}
	*/
	
	/*
	//read single user
	user u2 = um.readUser("rohit");
	System.out.println(u2.getEmail());
	*/
	
	/*
	//update user
	user u = new user();
	u.setUsername("rakesh");
	u.setPassword("ra123");
	u.setFirstName("Rakesh");
	u.setLastName("Gupta");
	u.setEmail("rakesh@gmail.com");
	u.setDateOfBirth("1980-07-16");
	um.updateUser("rakesh", u);
	*/
	
	//delete from user
	//um.deleteUser("rohit");
%>
</body>
</html>