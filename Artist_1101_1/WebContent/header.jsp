<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<header>
	<h1> Audition : 2019년 9월 문제 </h1>
</header>
<nav>
	<ul>
		<li><a href="<%= request.getContextPath() %>/artist/insertForm"> 오디션 등록 </a></li>
		<li><a href="<%= request.getContextPath() %>/artist/artistList"> 참가자 목록 조회 </a></li>
		<li><a href="<%= request.getContextPath() %>/artist/pointList"> 멘토 점수 조회 </a></li>
		<li><a href="<%= request.getContextPath() %>/artist/rankList"> 참가자 등수 조회 </a></li>
		<li><a href="<%= request.getContextPath() %>/index.jsp"> 홈으로 </a></li>
	</ul>
</nav>


