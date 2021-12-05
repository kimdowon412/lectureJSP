<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 출력화면 1</title>
</head>
<body>
	<h2>JSP 기초연습  1 - 요청 파라미터 정보 출력 화면</h2>
	
	[요청 파라미터 정보]
	- 입력 항목 별 name 값 : 아이디(userId), 비밀번호 (userPwd), 이름(userName), 나이(age), 이메일(email), 주소(addr) <br><br>
	
	<%-- 자바 코드 사용할때 (스크립트릿 사용) : <% 자바 코드 내용 %> --%>
	<%-- 값을 출력할 때 (표현식 사용) : <%= 값 or 변수명  %> --%>
	
	<!-- 요청 파라미터 정보 가져오기 -> request.getParameter("요청 파라미터 이름") -->
	아이디 : <%= request.getParameter("userId") %><br>
	비밀번호 : <%= request.getParameter("userPwd") %><br>
	이름 :<%= request.getParameter("userName") %><br>
	나이 : <%= request.getParameter("age") %><br>
	이메일 : <%= request.getParameter("email") %><br>
	주소 : <%= request.getParameter("addr") %><br>
</body>
</html>