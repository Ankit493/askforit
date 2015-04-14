package dbcon;
import com.mongodb.DB;
import com.mongodb.MongoClient;
public class connection {
	public DB db;
	public MongoClient mongoClient; 
	// To directly connect to a single MongoDB server (note that this will not
	// auto-discover the primary even
	// if it's a member of a replica set:
	
	public void init(){
		try {
			mongoClient = new MongoClient();
			db = mongoClient.getDB("cloudDB");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public DB getConnection() {
		if (db==null){
			init();
			return db;
		}else{
			return null;
		}
		
	}

}
