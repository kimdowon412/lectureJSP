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
@WebServlet("/member/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Controller> controllerMap = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//�슂泥� Path�� �꽌釉뚯빻�듃濡ㅻ윭 留듯븨�젙蹂대�� �벑濡�
		controllerMap.put("/member/insertForm", new InsertFormController());
		controllerMap.put("/member/memberInsert", new MemberInsertController());
		controllerMap.put("/member/memberList", new MemberListController());
		controllerMap.put("/member/moneyList", new MoneyListController());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//珥덇린�솕
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//�슂泥춑ath�뿉 �빐�떦�븯�뒗 �꽌釉뚯빻�듃濡ㅻ윭 �샇異� : /Shopping_1008/member/insertForm -> /member/insertForm
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller controller = controllerMap.get(path);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		MyView view = controller.process(request, response);
		view.render(request, response);
	}

}
