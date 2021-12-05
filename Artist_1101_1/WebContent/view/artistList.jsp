<%@ page import="vo.ArtistVO" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>


<%
	ArrayList<ArtistVO> artistList = 
		(ArrayList<ArtistVO>) request.getAttribute("artistList");
%>

<section>
	<h1> 참가자 목록 조회 </h1>
	<table>
		<tr>
			<td>참가번호</td>
			<td>참가자명</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>특기</td>
			<td>소속사</td>
		</tr>
		
		<%
			if (artistList != null)
				for (ArtistVO data : artistList) {
		%>
					<tr>
						<td> <%= data.getArtist_id() %> </td>
						<td> <%= data.getArtist_name() %> </td>
						<td> <%= data.getArtist_birth() %> </td>
						<td> <%= data.getArtist_gender() %> </td>
						<td> <%= data.getTalent() %> </td>
						<td> <%= data.getAgency() %> </td>
					</tr>
		<%
				}
		%>
	</table>
</section>


<%@ include file="../footer.jsp" %>