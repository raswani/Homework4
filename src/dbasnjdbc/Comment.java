package dbasnjdbc;

public class Comment {
	private int comment_id;
	private String username;
	private String movie_id;
	private String comment;
	private String date;
	
	
	public Comment() {
		super();
		
	}

	public Comment(int comment_id, String username, String movie_id, String comment, String date) {
		super();
		
		this.comment_id = comment_id;
		this.username = username;
		this.movie_id = movie_id;
		this.comment = comment;
		this.date = date;
		
	}

	public int getCommentId() {
		return comment_id;
	}

	public void setCommentId(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMovieId() {
		return movie_id;
	}

	public void setMovieId(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

}

