package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDAO;
import vo.ArtistVO;

public class ArtistInsertContrroller implements Controller {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArtistDAO dao = new ArtistDAO();
		ArtistVO vo = new ArtistVO();
		
		vo.setArtist_id(request.getParameter("id"));
		vo.setArtist_name(request.getParameter("name"));
		vo.setArtist_birth(request.getParameter("birth"));
		vo.setArtist_gender(request.getParameter("gender"));
		vo.setTalent(request.getParameter("talent"));
		vo.setAgency(request.getParameter("agency"));
		
	int	n = dao.insertArtist(vo);
	
	String path;
	
	if(n > 0) {
		path = "/artist/artistList";
	}else {
		path = "/view/artistInsert.jsp";
	}
	
		return new MyView(path);
	}

}
