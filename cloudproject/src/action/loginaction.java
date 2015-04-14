package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.sun.jersey.api.view.Viewable;
import com.sun.research.ws.wadl.Param;
import com.sun.research.ws.wadl.Request;
import com.sun.research.ws.wadl.Response;

import dbcon.connection;

import java.io.IOException;

@Path("/loginaction")
@Produces(MediaType.TEXT_HTML)
public class loginaction {
	// @Path("loginaction")
	// @Path("/{username}")
	@GET
	// @Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.TEXT_HTML })
	/*
	 * public Response execute(@QueryParam("username") String username) {
	 * System.out.println("hello world"); System.out.println("fname="+username);
	 * System.out.println("hello world2"); return null; }
	 */
	/*
	 * public Response insertdata(@QueryParam("firstname")String firstname,
	 * 
	 * @QueryParam("lastname")String lastname, @QueryParam("email")String email,
	 * @QueryParam("password")String password) {
	 * 
	 * connection mc = new connection(); DB db = mc.getConnection();
	 * DBCollection coll = db.getCollection("askforit");
	 * 
	 * BasicDBObject doc = new BasicDBObject("firstname", firstname)
	 * .append("lastname", lastname).append("email", email)
	 * .append("password",password);
	 * 
	 * coll.insert(doc); System.out.println("fname="+firstname);
	 * System.out.println("lname="+lastname);
	 * System.out.println("email="+email);
	 * System.out.println("password="+password);
	 * 
	 * System.out.println("/INDEX called new"); return null; }
	 */
	public Viewable index(@Context HttpServletRequest request,
			@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,
			@QueryParam("email") String email,
			@QueryParam("password") String password) {

		HttpSession session = request.getSession(true);
		// Object foo = session.getAttribute("foo");
		session.setAttribute("savedemail", email);

		System.out.println("fname=" + firstname);
		System.out.println("lname=" + lastname);
		System.out.println("email=" + email);
		System.out.println("password=" + password);
		connection mc = new connection();
		DB db = mc.getConnection();
		DBCollection coll = db.getCollection("askforit");

		BasicDBObject doc = new BasicDBObject("firstname", firstname)
				.append("lastname", lastname).append("email", email)
				.append("password", password);
		coll.insert(doc);
		//request.setAttribute("user", email);
		System.out.println("/INDEX called new login");
		return new Viewable("/signup.jsp", email);
	}

}
