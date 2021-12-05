package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//결과페이지 경로로 forward 
public class MyView {
	private String viewPath;

	public MyView(String viewPath) {
		this.viewPath = viewPath; //  /view/memberInsert.jsp
	}
	
	public void render(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
