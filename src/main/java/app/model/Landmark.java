package app.model;

import org.springframework.data.annotation.PersistenceConstructor;

public class Landmark {
	String id;
	String name;
	
	private double[] location;
	//float radius;
	String playlistId;
	
	@PersistenceConstructor
	Landmark(String name, double[] location) {
	    super();
	    this.name = name;
	    this.location = location;
	}
	
	Landmark() {
		
	}
	
	
	public Landmark(String name, double x, double y) {
	    super();
	    this.name = name;
	    this.location = new double[] { x, y };
	  }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}
	
	private double[] getLocation() {
		return this.location;
	}
	
//	public float getRadius() {
//		return radius;
//	}
//	public void setRadius(float radius) {
//		this.radius = radius;
//	}
	public String getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}
	
	public String customString() {
		
		return name;
	}
}
