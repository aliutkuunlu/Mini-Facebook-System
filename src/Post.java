import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Post implements PostInterface{

	private UUID id;
	private String text;
	private Date date;
	private Location location;
	private ArrayList<String> taggedFriends = new ArrayList<String>() ;
	
	public UUID getId() 
	{
		return id;
	}
	public void setId(UUID id) 
	{
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public ArrayList<String> getTaggedFriends() {
		return taggedFriends;
	}
	public void setTaggedFriends(ArrayList<String> taggedFriends) {
		this.taggedFriends = taggedFriends;
	}
	
}
