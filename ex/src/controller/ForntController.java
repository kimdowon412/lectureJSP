package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForntController
 */
@WebServlet("/artist/*")
public class ForntController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HashMap<String, Controller> controllerMap = new HashMap<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForntController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		controllerMap.put("/artist/insertForm", new InsertFormContrroller());
		controllerMap.put("/artist/artistInsert", new ArtistInsertContrroller());
		controllerMap.put("/artist/artistList", new ArtistListController());
		controllerMap.put("/artist/pointList", new PointListController());
		controllerMap.put("/artist/rankList", new RankListController());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requstURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = requstURI.substring(contextPath.length());
		
		Controller controller = controllerMap.get(path);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		MyView view = controller.process(request, response);
		view.render(request, response);
		
	}

}
