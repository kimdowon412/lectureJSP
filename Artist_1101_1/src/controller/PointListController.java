package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDAO;
import vo.PointVO;

public class PointListController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<PointVO> pointList = new ArrayList<>();
		ArtistDAO dao = new ArtistDAO();
		
		pointList = dao.selectPoint();
		request.setAttribute("pointList", pointList);

		return new MyView("/view/pointList.jsp");
	}

}
