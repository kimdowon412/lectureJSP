package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MoneyVO;

public class MoneyListController implements Controller{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB 연동 : 회원테이블&매출테이블 -> 회원정보, 회원이름, 등급, 회원별 매출금액 정보 가져오기
		MemberDAO dao = new MemberDAO();
		ArrayList<MoneyVO> list = dao.getMoneyList();
		
		request.setAttribute("moneyList", list);
		
		//정보 출력할View 경로를MyView에 지정해서 리턴
		return new MyView("/view/moneyList.jsp");
	}

}
