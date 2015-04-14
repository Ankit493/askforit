package action;

import java.util.Collection;

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
import com.sun.jersey.api.view.Viewable;

import dbcon.connection;

@Path("/signupaction")
@Produces(MediaType.TEXT_HTML)
public class signupaction {
	@GET
	@Produces({ MediaType.TEXT_HTML })
	public Viewable index(@Context HttpServletRequest request,
			@QueryParam("address") String address,
			@QueryParam("city") String city,
			@QueryParam("country") String country,
			@QueryParam("contact1") String contact1,
			@QueryParam("contact2") String contact2) {

		System.out.println("address=" + address);
		System.out.println("city=" + city);
		System.out.println("country=" + country);
		System.out.println("contact1=" + contact1);
		System.out.println("contact2=" + contact2);
		connection mc = new connection();
		DB db = mc.getConnection();
		DBCollection coll = db.getCollection("askforit");
		HttpSession session = request.getSession();
		//session.setAttribute("savedemail", email);

		String savedemail = (String) session.getAttribute("savedemail");
		System.out.println("email of session=" + savedemail);
		// db.getCollection("askforit").update({"email":savedemail},
		// {$addToSet:{"address":address}}, upsert, multi);
		// db.getCollection("askforit").update({"email":savedemail},
		// {$addToSet:{"address":address}});
		BasicDBObject newDocument = new BasicDBObject();
		BasicDBObject searchQuery = new BasicDBObject().append("email",
				savedemail);
		newDocument.append("$set",
				new BasicDBObject().append("address", address));
		coll.update(searchQuery, newDocument);
		searchQuery = new BasicDBObject().append("email", savedemail);
		newDocument.append("$set", new BasicDBObject().append("city", city));
		coll.update(searchQuery, newDocument);
		searchQuery = new BasicDBObject().append("email", savedemail);
		newDocument.append("$set",
				new BasicDBObject().append("country", country));
		coll.update(searchQuery, newDocument);
		searchQuery = new BasicDBObject().append("email", savedemail);
		newDocument.append("$set",
				new BasicDBObject().append("contact1", contact1));
		coll.update(searchQuery, newDocument);
		searchQuery = new BasicDBObject().append("email", savedemail);
		newDocument.append("$set",
				new BasicDBObject().append("contact2", contact2));
		coll.update(searchQuery, newDocument);

		/*
		 * BasicDBObject doc = new BasicDBObject("firstname", firstname)
		 * .append("lastname", lastname).append("email", email)
		 * .append("password",password); coll.insert(doc);
		 * request.setAttribute("user", firstname);
		 */
		request.setAttribute("user", savedemail);
		System.out.println("/INDEX called new signup");
		return new Viewable("/postadv.jsp", null);
	}

}
