package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDAO;
import vo.ArtistVO;

public class ArtistInsertController implements Controller {

    // 참가자 정보 등록 컨트롤러
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path;

        ArtistDAO dao = new ArtistDAO();
        ArtistVO vo = new ArtistVO();

        // vo에 우리가 입력한 값들을 보내주어야한다
        vo.setArtist_id(request.getParameter("id"));
        vo.setArtist_name(request.getParameter("name"));
        vo.setArtist_birth(request.getParameter("birth"));
        vo.setArtist_gender(request.getParameter("gender"));
        vo.setTalent(request.getParameter("talent"));
        vo.setAgency(request.getParameter("agency"));

        int n = dao.insertArtist(vo);

        if(n > 0) {
            path = "/artist/artistList";
        }else {
            path = "/view/artistInsert.jsp";
        }

        return new MyView(path);
    }

}