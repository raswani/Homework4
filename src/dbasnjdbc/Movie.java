package dbasnjdbc;

public class Movie {
	private String movie_id;
	private String release_date;
	private String title;
	private String poster_image;
	
	
	public Movie() {
		super();
		
	}

	public Movie(String movie_id, String release_date, String title, String poster_image) {
		super();
		
		this.movie_id = movie_id;
		this.release_date = release_date;
		this.title = title;
		this.poster_image = poster_image;
		
	}

	public String getMovieId() {
		return movie_id;
	}

	public void setMovieId(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getReleaseDate() {
		return release_date;
	}

	public void setReleaseDate(String release_date) {
		this.release_date = release_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterImage() {
		return poster_image;
	}

	public void setPosterImage(String poster_image) {
		this.poster_image = poster_image;
	}


}

