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

import dbasnjdbc.Comment;

public class CommentManager {

	DataSource ds;
	
	
	String add_comment = "INSERT INTO Comment (username, movie_id, comment, date)"
			+ " VALUES (?,?,?,?);";
	
	String read_all = "select * from Comment";
	String read_all_comments_for_username = "select * from Comment where username = ?;";
	String read_all_comments_for_movieid = "select * from Comment where movie_id = ?;";
	String read_comment_for_commentid = "select * from Comment where comment_id = ?";
	String update_comment = "update comment set username = ?, movie_id = ?, comment = ? date = ? where comment_id = ?";
	String delete_comment = "delete from Comment where comment_id = ?";
	
	public CommentManager()
	{
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dbasn4");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean  createComment(Comment com)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(add_comment);
			statement.setString(1, com.getUsername());
			statement.setString(2, com.getMovieId());
			statement.setString(3, com.getComment());
			statement.setString(4, com.getDate());
			statement.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Comment> readAllComments()
	{
		List<Comment> com = new ArrayList<Comment>();
		try
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all);
			ResultSet results = statement.executeQuery();
			while(results.next()) 
			{
				Comment com1 = new Comment (
						
						results.getInt("comment_id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
						
				com.add(com1);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return com;
	}
	
	public List<Comment> readCommentForUsername(String uname)
	{
		List<Comment> com = new ArrayList<Comment>();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all_comments_for_username);
			statement.setString(1, uname);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment com1 = new Comment (
						results.getInt("comment_id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
			
				com.add(com1);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return com;
	}
	
	public List<Comment> readCommentForCommentId(int comment_id)
	{
		List<Comment> com = new ArrayList<Comment>();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_comment_for_commentid);
			statement.setInt(1, comment_id);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment com1 = new Comment (
						results.getInt("comment_id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
			
				com.add(com1);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return com;
	}
	
	public List<Comment> readCommentForMovieId(String movie_id)
	{
		List<Comment> com = new ArrayList<Comment>();
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(read_all_comments_for_movieid);
			statement.setString(1, movie_id);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Comment com1 = new Comment (
						results.getInt("comment_id"),
						results.getString("username"),
						results.getString("movie_id"),
						results.getString("comment"),
						results.getString("date"));
			
				com.add(com1);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return com;
	}
	
	public void updateComment(int comment_id, Comment com)
	{
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(update_comment);
			statement.setString(1, com.getUsername());
			statement.setString(2, com.getMovieId());
			statement.setString(3, com.getComment());
			statement.setString(4, com.getDate());
			statement.setInt(5, comment_id);
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteComment(int comment_id){
		
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete_comment);
			statement.setInt(1, comment_id);	
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
