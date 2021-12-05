<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 입력화면 1</title>
</head>
<body>
	<h2>JSP 기초연습  1 - 사용자 입력 데이터 보내기</h2>
	
	[회원가입 정보]<br>
	조건 0. 사용자 정보 입력화면 : input01.jsp, 사용자 정보 출력 화면 : output01.jsp<br>
	조건 1. 입력 항목 별 name 값 설정 : 아이디(userId), 비밀번호 (userPwd), 이름(userName), 나이(age), 이메일(email), 주소(addr)<br>
	조건 2. 전송 버튼을 누르면 output01.jsp로 사용자 입력 정보를 전송함.<br>
	조건 3. 다시 입력 버튼을 누르면 입력 내용이 취소됨.<br><br>
	
	<!-- form 태그 : 사용자가 입력한 정보를 웹 서버로 보내는 역할 -->
	<form action="output01.jsp" method="get">
	
	<!-- <input type="타입" name="전송 파라미터 이름" value="화면 출력 값"> -->
		아이디 : <input type="text" name="userId"><br>
		비밀번호 : <input type="password" name="userPwd"><br> 
		이름 : <input type="text" name="userName"><br>
		나이 : <input type="text" name="age"><br>
		이메일 : <input type="email" name="email"><br>
		주소 : <input type="text" name="addr"><br><br>
		
		<input type="submit" value="전송"> <!-- submit : 클릭하면 입력정보를 웹서버(action 경로)로 전송 -->
		<input type="reset" value="다시입력"> <!-- reset : 입력 정보 취소 -->
	</form>
	
</body>
</html>