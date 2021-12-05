package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDAO;
import vo.ArtistVO;

public class ArtistListController implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<ArtistVO> artistList = new ArrayList<>();
		ArtistDAO dao = new ArtistDAO();
		
		artistList = dao.selectArtist();
		request.setAttribute("artistList", artistList);

		return new MyView("/view/artistList.jsp");
	}

}
