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

import dbasnjdbc.Actor;

public class ActorManager {

	DataSource ds;
	
	
	String add_actor = "INSERT INTO Actor (actor_id, actor_first_name, actor_last_name, actor_dob)"
			+ " VALUES (?,?,?,?);";
	
	String read_all = "select * from Actor";
	String read_actor = "select * from Actor where actor_id = ?";
	String update_actor = "update user set actor_first_name = ?, actor_last_name = ?, actor_dob = ? where actor_id = ?";
	String delete_actor = "delete from Actor where actor_id = ?";
	
	public ActorManager()
	{
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dbasn4");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean  createActor(Actor ac)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_actor);
			statement.setString(1, ac.getActorId());
			statement.setString(2, ac.getActorFirstName());
			statement.setString(3, ac.getActorLastName());
			statement.setString(4, ac.getActorDOB());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Actor> readAllActors()
	{
		List<Actor> ac = new ArrayList<Actor>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				Actor ac1 = new Actor (
						
						results.getString("actor_id"),
						results.getString("actor_first_name"),
						results.getString("actor_last_name"),
						results.getString("actor_dob")
						
						);
				ac.add(ac1);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ac;
	}
	
	public Actor readActor(String actor_id)
	{
		Actor ac1 = new Actor();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_actor);
			statement.setString(1, actor_id);
			ResultSet results = statement.executeQuery();
			if(results.next())
			{
				ac1 = new Actor (
						
						results.getString("actor_id"),
						results.getString("actor_first_name"),
						results.getString("actor_last_name"),
						results.getString("actor_dob")
						
						);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ac1;
	}
	
	public void updateActor(String actor_id, Actor ac)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_actor);
			statement.setString(1, ac.getActorFirstName());
			statement.setString(2, ac.getActorLastName());
			statement.setString(3, ac.getActorDOB());
			
			statement.setString(4, actor_id);
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteActor(String actor_id){
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_actor);
			statement.setString(1, actor_id);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
