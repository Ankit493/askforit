package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.BSONObject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.sun.jersey.api.view.Viewable;

import dbcon.connection;

@Path("/login")
public class login {
	String fname, lname, addr, city, country, cont1, cont2, savedemail, pwd;
	String title, location, desc, categ, tag;
	Map adMap;
	List adList;

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_HTML)
	// public Viewable openHtmlPageWithName(){
	// String name = "Prakash";
	// return new Viewable("/name.jsp", name);
	// }
	public Viewable index(@Context HttpServletRequest request,
			@QueryParam("username") String email,
			@QueryParam("password") String password) {

		HttpSession session = request.getSession();
		session.setAttribute("savedemail", email);

		System.out.println("username=" + email);
		System.out.println("password=" + password);
		connection mc = new connection();
		DB db = mc.getConnection();
		DBCollection coll = db.getCollection("askforit");
		BasicDBObject query = new BasicDBObject();
		query.put("email", email);
		query.put("password", password);

		// ArrayList<WrapAdObject> savedAds = (ArrayList<WrapAdObject>) session
		// .getAttribute("ads");

		// WrapAdObject wao[] = new WrapAdObject[10];
		// int i=0;

		// BasicDBObject projId = new BasicDBObject();

		DBCursor cursor = coll.find(query);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
			fname = (String) cursor.one().get("firstname");
			lname = (String) cursor.one().get("lastname");
			// savedemail=(String) cursor.one().get("email");
			// pwd=(String) cursor.one().get("password");
			addr = (String) cursor.one().get("address");
			city = (String) cursor.one().get("city");
			country = (String) cursor.one().get("country");
			cont1 = (String) cursor.one().get("contact1");
			cont2 = (String) cursor.one().get("contact2");

			adMap = new HashMap();
			BasicDBList adList = (BasicDBList) cursor.one()
					.get("postadvertise");
			for (int i = 0; i < adList.size(); i++) {
				System.out.println("Hiii in for loop");
				Map ad = new HashMap();
				BasicDBObject adObj = (BasicDBObject) adList.get(i);
				title = adObj.getString("title");
				tag = adObj.getString("tag");
				categ = adObj.getString("category");
				location = adObj.getString("location");
				desc = adObj.getString("description");
				System.out.println(title);

				ad.put("Title", title);
				ad.put("Description", desc);
				ad.put("Category", categ);
				ad.put("Location", location);
				ad.put("Tag", tag);

				adMap.put(i + 1, ad);
			}

			session.setAttribute("savedemail", email);
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			session.setAttribute("pwd", password);
			session.setAttribute("addr", addr);
			session.setAttribute("city", city);
			session.setAttribute("country", country);
			session.setAttribute("cont1", cont1);
			session.setAttribute("cont2", cont2);
			//session.setAttribute("ads", adMap);
			request.setAttribute("user1", email);
			session.setAttribute("user", email);

			// javax.ws.rs.core.Response.
			return new Viewable("/profile.jsp", adMap);

		}

		// request.setAttribute("user",savedemail);
		System.out.println("/INDEX called new postadv");
		return new Viewable("/error.jsp", null);
		// return new Viewable("/welcome.jsp", null);
	}
}
