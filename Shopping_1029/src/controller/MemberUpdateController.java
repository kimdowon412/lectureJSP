package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberUpdateController implements Controller{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		System.out.println("MemberUpdateController 실행...");
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		MemberVO vo = new MemberVO();
		vo.setCustno(custno);
		vo.setCustname(request.getParameter("custname"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("addr"));
		vo.setJoindate(Date.valueOf(request.getParameter("joindate")));
		vo.setGrade(request.getParameter("grade"));
		vo.setCity(request.getParameter("city"));
		
		MemberDAO dao = new MemberDAO();
		int n = dao.updateMember(vo);
		
		if(n>0) {
			out.print("<script> alert('회원정보수정이 완료되었습니다.'); </script>");
		}
		
		return new MyView("/member/updateForm?custno=" + custno);
	}
	
}
