package action;
import org.bson.types.ObjectId;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.io.Serializable;
 
public class advdetail implements Serializable {
	
	
	public String  title;
	public String  tag;
	public String  description;
	public String  category;
	public String  location;
	

	/*public advdetail( String title, String tag )
	{
	this.title  = title;
	this.tag = tag;
	}*/
	
	
	
	
	
	public advdetail( String title, String tag, String description, String category,String location )
	{
	this.title  = title;
	this.tag = tag;
	this.description   = description;
	this.category=category;
	this.location  = location;
	}
	
	
	
	
	
	
	
	public DBObject bsonFromPojo()
	{
	BasicDBObject document = new BasicDBObject();
	document.put( "title",    this.title );
	document.put( "tag",   this.tag );
	document.put( "description", this.description);
	document.put( "category",   this.category);
	document.put( "location",  this.location);
	return document;
	}
	

}
