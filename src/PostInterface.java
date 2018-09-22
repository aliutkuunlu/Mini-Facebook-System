import java.sql.Date;
import java.util.UUID;

public interface PostInterface {
	
	void setText(String text);
	String getText();
	UUID getId();
	Date getDate();
	
}
