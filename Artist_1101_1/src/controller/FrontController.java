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
 * Servlet implementation class FrontController
 */
@WebServlet("/artist/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Controller> controllerMap = new HashMap<>();
	
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		controllerMap.put("/artist/insertForm", new InsertFormController());
		controllerMap.put("/artist/artistInsert", new ArtistInsertController());
		controllerMap.put("/artist/artistList", new ArtistListController());
		controllerMap.put("/artist/pointList", new PointListController());
		controllerMap.put("/artist/rankList", new RankListController());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//초기화 작업
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		//요청 :  /Audition/artist/artistForm
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = requestURI.substring(contextPath.length());
		
		Controller controller = controllerMap.get(path);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		MyView view = controller.process(request, response);
		view.render(request, response);
	}

}
