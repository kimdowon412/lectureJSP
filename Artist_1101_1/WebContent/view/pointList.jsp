<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="vo.PointVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../header.jsp" %>


<%
	ArrayList<PointVO> pointList = 
		(ArrayList<PointVO>) request.getAttribute("pointList");
%>

<section>
	<h1> 참가자 목록 조회 </h1>
	<table>
		<tr>
			<td>참가번호</td>
			<td>참가자명</td>
			<td>생년월일</td>
			<td>점수</td>
			<td>등급</td>
			<td>멘토</td>
		</tr>
		
		<%
			if (pointList != null)
				for (PointVO data : pointList) {
		%>
					<tr>
						<td> <%= data.getArtist_id() %> </td>
						<td> <%= data.getArtist_name() %> </td>
						<td> <%= data.getArtist_birth() %> </td>
						<td> <%= data.getPoint() %> </td>
						<td> <%= data.getGrade() %> </td>
						<td> <%= data.getMento_name() %> </td>
					</tr>
		<%
				}
		%>
	</table>
</section>


<%@ include file="../footer.jsp" %>