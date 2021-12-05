<%@page import="vo.PointVO"%>
<%@page import="vo.ArtistVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%
	ArrayList<PointVO> list = (ArrayList<PointVO>) request.getAttribute("PointList");
%>
<section>
	<h1>멘토 점수 조회</h1>
	<table border="1">
		<tr>
			<td>참가번호</td>
			<td>참가자명</td>
			<td>생년월일</td>
			<td>점수</td>
			<td>등급</td>
			<td>멘토</td>
		</tr>
		<%
				if(list != null){
					for (PointVO data : list){
			%>
		<tr>
			<td><%= data.getArtistId() %></td>
			<td><%= data.getArtistName() %></td>
			<td><%= data.getBirth() %></td>
			<td><%= data.getPoint() %></td>
			<td><%= data.getGrade() %></td>
			<td><%= data.getMentoName() %></td>
		</tr>
		<%
					}
				}
			%>
	</table>
</section>

<%@ include file="../footer.jsp"%>