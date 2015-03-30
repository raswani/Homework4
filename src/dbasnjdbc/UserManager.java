package dbasnjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dbasnjdbc.user;

public class UserManager {

	DataSource ds;
	
	
	String add_user = "INSERT INTO user (username, password, first_name, last_name, email, dateofbirth )"
			+ " VALUES (?,?,?,?,?,?);";
	
	String read_all = "select * from user";
	String read_user = "select * from user where username = ?";
	String update_user = "update user set password = ?, first_name = ?, last_name = ?, email = ?, dateofbirth = ? where username = ?";
	String delete_user = "delete from user where username = ?";
	
	public UserManager()
	{
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dbasn4");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean  createUser(user us)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_user);
			statement.setString(1, us.getUsername());
			statement.setString(2, us.getPassword());
			statement.setString(3, us.getFirstName());
			statement.setString(4, us.getLastName());
			statement.setString(5, us.getEmail());
			statement.setString(6, us.getDateOfBirth());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<user> readAllusers()
	{
		List<user> us = new ArrayList<user>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				user us1 = new user (
						
						results.getString("username"),
						results.getString("password"),
						results.getString("first_name"),
						results.getString("last_name"),
						results.getString("email"),
						results.getString("dateofbirth")
						);
				us.add(us1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return us;
	}
	
	public user readuser(String user_name)
	{
		user us1 = new user();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_user);
			statement.setString(1, user_name);
			ResultSet results = statement.executeQuery();
			if(results.next())
			{
				us1 = new user (
						
						results.getString("username"),
						results.getString("password"),
						results.getString("first_name"),
						results.getString("last_name"),
						results.getString("email"),
						results.getString("dateofbirth")
						);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return us1;
	}
	
	public void updateUser(String user_name, user us)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_user);
			statement.setString(1, us.getPassword());
			statement.setString(2, us.getFirstName());
			statement.setString(3, us.getLastName());
			statement.setString(4, us.getEmail());
			statement.setString(5, us.getDateOfBirth());
			statement.setString(6, user_name);
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String user_name){
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_user);
			statement.setString(1, user_name);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
