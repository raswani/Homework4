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

import dbasnjdbc.Movie;

public class MovieManager {

	DataSource ds;
	
	
	String add_movie = "INSERT INTO Movie (movie_id, release_date, title, poster_image)"
			+ " VALUES (?,?,?,?);";
	
	String read_all = "select * from movie";
	String read_movie = "select * from movie where movie_id = ?";
	String update_movie = "update user set release_date = ?, title = ?, poster_image = ? where movie_id = ?";
	String delete_movie = "delete from movie where movie_id = ?";
	
	public MovieManager()
	{
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dbasn4");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean  createMovie(Movie mo)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_movie);
			statement.setString(1, mo.getMovieId());
			statement.setString(2, mo.getReleaseDate());
			statement.setString(3, mo.getTitle());
			statement.setString(4, mo.getPosterImage());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Movie> readAllMovies()
	{
		List<Movie> mo = new ArrayList<Movie>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				Movie mo1 = new Movie (
						
						results.getString("movie_id"),
						results.getString("release_date"),
						results.getString("title"),
						results.getString("poster_image")
						
						);
				mo.add(mo1);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mo;
	}
	
	public Movie readMovie(String movie_id)
	{
		Movie mo1 = new Movie();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_movie);
			statement.setString(1, movie_id);
			ResultSet results = statement.executeQuery();
			if(results.next())
			{
				mo1 = new Movie (
						
						results.getString("movie_id"),
						results.getString("release_date"),
						results.getString("title"),
						results.getString("poster_image")
						
						);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mo1;
	}
	
	public void updateMovie(String movie_id, Movie mo)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_movie);
			statement.setString(1, mo.getReleaseDate());
			statement.setString(2, mo.getTitle());
			statement.setString(3, mo.getPosterImage());
			
			statement.setString(4, movie_id);
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMovie(String movie_id){
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_movie);
			statement.setString(1, movie_id);	
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
