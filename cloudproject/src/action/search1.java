package action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

@Path("/search1")
@Produces(MediaType.TEXT_HTML)
public class search1 {
	Map adMap;
	List adList;
	@GET
	@Produces({ MediaType.TEXT_HTML })
	public Viewable index(@Context HttpServletRequest request,@QueryParam("location") String place)
			 {
		System.out.println("place=" + place);
		HttpSession session=request.getSession();
		session.setAttribute("place", place);
		connection mc = new connection();
		DB db = mc.getConnection();
		DBCollection coll = db.getCollection("askforit");
		BasicDBObject query = new BasicDBObject();
		query.put("postadvertise.location", place);
		DBCursor cursor = coll.find(query);
		//List<advdetail> adv = new ArrayList<Storeadadvdetail>();
		//ArrayList< String> al=new ArrayList<String>();
		//ArrayList<advdetail> postadvertise=new ArrayList<advdetail>();
		//Map<String, Object> map = new HashMap<String, Object>();
		 //map.put("user", "ankit");
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
			      //  advdetail student = new advdetail();
			        //student.setFirstName(firstName);
			        //student.setLastName(lastName);
			        //student.setAge(age);
			        //student.setGender(gender);
			    
			        
			        
			        if(location.equals(place)){
			        	Map ad = new HashMap();	
			     /*   System.out.println("title="+title);
			        System.out.println("tag="+tag);
			        System.out.println("description="+description);
			        System.out.println("category="+category);
			        System.out.println("location="+location);*/
			        ad.put("Title", title);
					ad.put("Description", description);
					ad.put("Category", category);
					ad.put("Location", location);
					ad.put("Tag", tag);
					

					adMap.put(p + 1, ad);
					p++;
			       /* advdetail adv=new  advdetail(title,tag,description,category,location);
			       al.add(title);
			       al.add(tag);
			       al.add(description);
			       al.add(category);
			       al.add(location);
			       al.add("finished next will start");
			       map.put("items", al);
			        postadvertise.add(adv);*/
			       
			        }
			        
			        
			        
			       // return new Viewable("/search.jsp", null);
			    //    students.add(student);
			    }               
			
			 
			
			//System.out.println(cursor.next());
			

		}
		   
      /* Map<String, Object> map = new HashMap<String, Object>();
       // map.put("user", "usul");
        ArrayList<String> l = new ArrayList<String>();
        l.add("light saber");
        l.add("fremen clothes");
        map.put("items", l);*/
		// map.put("items", postadvertise);
		return new Viewable("/search1.jsp",adMap);
		
		
			 }
	
	
	

}
