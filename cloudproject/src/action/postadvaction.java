package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.sun.jersey.api.view.Viewable;

import dbcon.connection;

@Path("/postadvaction")
@Produces(MediaType.TEXT_HTML)
public class postadvaction {

	@GET
	// @Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.TEXT_HTML })
	public Viewable index(@Context HttpServletRequest request,
			@QueryParam("title") String title, @QueryParam("tag") String tag,
			@QueryParam("description") String description,
			@QueryParam("category") String category,
			@QueryParam("location") String location) {

		System.out.println("title=" + title);
		System.out.println("tag=" + tag);
		System.out.println("description=" + description);
		System.out.println("category=" + category);
		System.out.println("location=" + location);
		connection mc = new connection();
		DB db = mc.getConnection();
		DBCollection coll = db.getCollection("askforit");
		HttpSession session = request.getSession();
		String savedemail = (String) session.getAttribute("savedemail");
		System.out.println("email of session=" + savedemail);
		// db.getCollection("askforit").update({"email":savedemail},
		// {$addToSet:{"address":address}}, upsert, multi);
		// db.getCollection("askforit").update({"email":savedemail},
		// {$addToSet:{"address":address}});

		advdetail adv = new advdetail(title, tag, description, category,
				location);

		BasicDBObject account = new BasicDBObject();

		DBObject dbo;
		dbo = adv.bsonFromPojo();
		ArrayList<DBObject> array = new ArrayList<DBObject>();

		array.add(dbo);

		/*
		 * BasicDBObject newDocument = new BasicDBObject(); BasicDBObject
		 * searchQuery = new BasicDBObject().append("email",savedemail);
		 * newDocument.append("$set", new
		 * BasicDBObject().append("address",address)); coll.update(searchQuery,
		 * newDocument);
		 */

		// account.put("postedadvertise", array);
		BasicDBObject searchQuery = new BasicDBObject().append("email",
				savedemail);

		// account.put("$push", new
		// BasicDBObject().append("postadvertise",array));
		account.put("$push", new BasicDBObject().append("postadvertise", dbo));
		coll.update(searchQuery, account, true, true);

		/*
		 * account.append("$push", new
		 * BasicDBObject().append("postadvertise",array));
		 * coll.update(searchQuery, account); // coll.insert(account);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * /*BasicDBObject doc = new BasicDBObject("firstname", firstname)
		 * .append("lastname", lastname).append("email", email)
		 * .append("password",password); coll.insert(doc);
		 * request.setAttribute("user", firstname);
		 */
		System.out.println("/INDEX called new ppoatadv");
		return new Viewable("/profile.jsp", null);
	}

}
