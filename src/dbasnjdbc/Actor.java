package dbasnjdbc;

public class Actor {
	private String actor_id;
	private String actor_first_name;
	private String actor_last_name;
	private String actor_dob;
	
	
	public Actor() {
		super();
		
	}

	public Actor(String actor_id, String actor_first_name, String actor_last_name, String actor_dob) {
		super();
		
		this.actor_id = actor_id;
		this.actor_first_name = actor_first_name;
		this.actor_last_name = actor_last_name;
		this.actor_dob = actor_dob;
		
	}

	public String getActorId() {
		return actor_id;
	}

	public void setActorId(String actor_id) {
		this.actor_id = actor_id;
	}

	public String getActorFirstName() {
		return actor_first_name;
	}

	public void setActorFirstName(String actor_first_name) {
		this.actor_first_name = actor_first_name;
	}

	public String getActorLastName() {
		return actor_last_name;
	}

	public void setActorLastName(String actor_last_name) {
		this.actor_last_name = actor_last_name;
	}

	public String getActorDOB() {
		return actor_dob;
	}

	public void setActorDOB(String actor_dob) {
		this.actor_dob = actor_dob;
	}


}

