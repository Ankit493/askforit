package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.sun.jersey.api.view.Viewable;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import dbcon.connection;

@Path("/ajaxcall")
@Produces(MediaType.TEXT_HTML)
public class ajaxcall {
	Map adMap;
	List adList;
	
	@GET
	@Produces({ MediaType.TEXT_HTML })
	public Viewable index(@Context HttpServletRequest request,@QueryParam("q") String category1)
			 {
		HttpSession session = request.getSession();
		String place=(String)session.getAttribute("place");
		System.out.println("ajax place of session="+place);
		connection mc = new connection();
		DB db = mc.getConnection();
		DBCollection coll = db.getCollection("askforit");
		BasicDBObject query = new BasicDBObject();
		
		List<BasicDBObject> obj = (List) new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("postadvertise.category", category1));
		obj.add(new BasicDBObject("postadvertise.location",place));
		query.put("$and", obj);
		
		//query.put("postadvertise.category", category1);
		//query.put("postadvertise.location",place);
		
		DBCursor cursor = coll.find(query);
		
		int p=0;
		adMap = new HashMap();
		while (cursor.hasNext()) {
			

			
			 DBObject theObj = cursor.next();
			 BasicDBList advList = (BasicDBList) theObj.get("postadvertise");
			 for (int i = 0; i < advList.size(); i++) {
			        BasicDBObject advObj = (BasicDBObject) advList.get(i);
			        String title = advObj.getString("title");
			        String tag = advObj.getString("tag");
			        String description = advObj.getString("description");
			        String category = advObj.getString("category");
			        String location = advObj.getString("location");
			        
			        
			        if(category.equals(category1) && location.equals(place)){
			        	Map ad = new HashMap();	
			        System.out.println("titleaj="+title);
			        System.out.println("tagaj="+tag);
			        System.out.println("descriptionaj="+description);
			        System.out.println("categoryaj="+category);
			        System.out.println("locationaj="+location);
			        ad.put("Title", title);
					ad.put("Description", description);
					ad.put("Category", category);
					ad.put("Location", location);
					ad.put("Tag", tag);
					

					adMap.put(p + 1, ad);
					p++;
			
			       
			        }
	
			    }               

		}
		   

		return new Viewable("/category.jsp",adMap);
		
		
			 }
	
	
	

}
