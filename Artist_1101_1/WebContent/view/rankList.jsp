<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="vo.PointVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../header.jsp" %>

<% 
	ArrayList<PointVO> list = (ArrayList<PointVO>)request.getAttribute("rankList");
%>


<section>
	<h1> 참가자 등수 조회 </h1>
	<table>
		<tr>
			<td>참가번호</td>
			<td>참가자명</td>
			<td>점수</td>
			<td>평균</td>
			<td>순위</td>
		</tr>
<%
	if(list != null) {
		for(PointVO data : list) {
%>			
	<tr>
		<td> <%= data.getArtist_id() %> </td>
		<td> <%= data.getArtist_name() %> </td>
		<td> <%= data.getPoint() %> </td>
		<td> <%= data.getAverage() %> </td>
		<td> <%= data.getRank() %> </td>
	</tr>
<%
		}
	}
%>
	</table>
</section>


<%@ include file="../footer.jsp" %>