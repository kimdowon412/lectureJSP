package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class InsertFormController implements Controller{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//회원정보 max+1 값을 request에 속성으로 저장 : DB 연동 필요
		MemberDAO dao = new MemberDAO();
		int custno = dao.getMaxCustNo();
		
		request.setAttribute("custno", custno);
		
		// 결과페이지(회원정보등록 jsp) 경로 설정해서 MyView 리턴
		return new MyView("/view/memberInsert.jsp");
	}

}
