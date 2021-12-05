package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberInsertController implements Controller{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DB추가
		MemberVO vo = new MemberVO();
		vo.setCustno(Integer.parseInt(request.getParameter("custno")));
		vo.setCustname(request.getParameter("custname"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("addr"));
		vo.setJoindate(Date.valueOf(request.getParameter("joindate")));
		vo.setGrade(request.getParameter("grade"));
		vo.setCity(request.getParameter("city"));
		
		MemberDAO dao = new MemberDAO();
		int n = dao.insertMember(vo);
		
		PrintWriter out = response.getWriter();
		
		//  n : SQL문 실행했을 때 성공한 레코드 갯수
		if(n>0) {
			out.println("<script> alert('회원등록이 완료되었습니다.'); </script>");
		}
		
		return new MyView("/member/insertForm");
	}

}
