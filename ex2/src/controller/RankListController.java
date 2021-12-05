package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDAO;
import vo.PointVO;

public class RankListController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<PointVO> list = new ArrayList<>();
		ArtistDAO dao = new ArtistDAO();
		
		list = dao.selectRank();
		request.setAttribute("rankList", list);
		return new MyView("/view/rankList.jsp");
	}

}
