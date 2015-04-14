package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.view.Viewable;

@Path("/logout")
public class Logout {

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Viewable index(@Context HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		
		return new Viewable("/welcome.jsp", null);
	}

}
