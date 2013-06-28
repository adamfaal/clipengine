package net.petersson.clipengine;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class AddClipServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(AddClipServlet.class.getName());

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		final String _method = request.getParameter("_method") == null ? "NULL" : request.getParameter("_method");
		if (_method.equalsIgnoreCase("PUT")) {
			doPut(request, response);
			return;
		}
		final String msg = String.format("doPost() invalid _method: %s", _method.toUpperCase());
		log.log(Level.SEVERE, msg);
		throw new RuntimeException(msg);

	}

	/**
	 * 
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

		final String description = request.getParameter("description");
		final String mimeType = request.getParameter("mimeType");
		final String clip = request.getParameter("clip");

		User currentUser = UserServiceFactory.getUserService().getCurrentUser();
		if (currentUser == null) {
			respondWithAccessDenied(request, response);
			return;
		}

		response.sendRedirect("/addClip");

	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.getRequestDispatcher("/addClipForm.jsp").forward(request, response);
		} //
		catch (Exception e) {
			log.log(Level.SEVERE, String.format("doGet()"), e);
		}

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void respondWithAccessDenied(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendError(HttpServletResponse.SC_FORBIDDEN, "User must be logged in");

	}

}
