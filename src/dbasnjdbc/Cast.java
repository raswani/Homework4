package dbasnjdbc;

public class Cast {
	private int cast_id;
	private String movie_id;
	private String actor_id;
	private String character_name;
	
	public Cast() {
		super();
		
	}

	public Cast(int cast_id,  String movie_id, String actor_id, String character_name) {
		super();
		
		this.cast_id = cast_id;
		this.movie_id = movie_id;
		this.actor_id = actor_id;
		this.character_name = character_name;
		
		
	}

	public int getCastId() {
		return cast_id;
	}

	public void setCastId(int cast_id) {
		this.cast_id = cast_id;
	}

	public String getMovieId() {
		return movie_id;
	}

	public void setMovieId(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getActorId() {
		return actor_id;
	}

	public void setActorId(String actor_id) {
		this.actor_id = actor_id;
	}

	public String getCharacterName() {
		return character_name;
	}

	public void setCharacterName(String character_name) {
		this.character_name = character_name;
	}

}

