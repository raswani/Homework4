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

import dbasnjdbc.Cast;

public class CastManager {

	DataSource ds;
	
	
	String add_cast = "INSERT INTO Cast (actor_id, movie_id, character_name)"
			+ " VALUES (?,?,?);";
	
	String read_all = "select * from Cast";
	String read_all_cast_for_actor_id = "select * from Cast where actor_id = ?;";
	String read_all_cast_for_movieid = "select * from Cast where movie_id = ?;";
	String read_all_for_cast_id = "select * from Cast where cast_id = ?";
	String update_cast = "update Cast set actor_id = ?, movie_id = ?, character_name = ? where cast_id = ?";
	String delete_cast = "delete from Cast where cast_id = ?";
	
	public CastManager()
	{
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dbasn4");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean  createCast(Cast ca)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_cast);
			statement.setString(1, ca.getActorId());
			statement.setString(2, ca.getMovieId());
			statement.setString(3, ca.getCharacterName());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Cast> readAllCasts()
	{
		List<Cast> ca = new ArrayList<Cast>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				Cast ca1 = new Cast (
						
						results.getInt("cast_id"),
						results.getString("actor_id"),
						results.getString("movie_id"),
						results.getString("character_name"));
						
						
				ca.add(ca1);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ca;
	}
	
	public List<Cast> readCastForActor(String actor_id)
	{
		List<Cast> ca = new ArrayList<Cast>();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all_cast_for_actor_id);
			statement.setString(1, actor_id);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast ca1 = new Cast (
						results.getInt("cast_id"),
						results.getString("actor_id"),
						results.getString("movie_id"),
						results.getString("character_name"));
			
				ca.add(ca1);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ca;
	}
	
	public List<Cast> readCastForCastId(int cast_id)
	{
		List<Cast> ca = new ArrayList<Cast>();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all_for_cast_id);
			statement.setInt(1, cast_id);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast ca1 = new Cast (
						results.getInt("cast_id"),
						results.getString("actor_id"),
						results.getString("movie_id"),
						results.getString("character_name"));
						
			
				ca.add(ca1);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ca;
	}
	
	public List<Cast> readCastForMovieId(String movie_id)
	{
		List<Cast> ca = new ArrayList<Cast>();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all_cast_for_movieid);
			statement.setString(1, movie_id);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast ca1 = new Cast (
						results.getInt("cast_id"),
						results.getString("actor_id"),
						results.getString("movie_id"),
						results.getString("character_name"));
						
			
				ca.add(ca1);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ca;
	}
	
	public void updateCast(int cast_id, Cast ca)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_cast);
			statement.setString(1, ca.getActorId());
			statement.setString(2, ca.getMovieId());
			statement.setString(3, ca.getCharacterName());
			statement.setInt(4, cast_id);
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCast(int cast_id){
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_cast);
			statement.setInt(1, cast_id);	
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
