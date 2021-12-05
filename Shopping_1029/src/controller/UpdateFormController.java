package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class UpdateFormController implements Controller{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.getMemberData(custno);
		request.setAttribute("member", member);
		
		return new MyView("/view/memberUpdate.jsp");
	}
	
}