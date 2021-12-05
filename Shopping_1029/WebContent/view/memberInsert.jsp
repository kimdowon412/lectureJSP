<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<%
	int custno = (int)request.getAttribute("custno");
%>

<section>
	<h1> 홈쇼핑 회원 등록 </h1>
	<form action="<%=request.getContextPath() %>/member/memberInsert" method="post" name="frm" onsubmit="return checkForm()">
		<table>
			<tr>
				<td> 회원번호(자동발생) </td>
				<td> <input type="number" value=<%= custno %> name="custno" id="custno" readonly="readonly"> </td>
			</tr>
			<tr>
				<td> 회원성명 </td>
				<td> <input type="text" name="custname" id="custname"> </td>
			</tr>
			<tr>
				<td> 회원전화 </td>
				<td> <input type="text" name="phone" id="phone"> </td>
			</tr>
			<tr>
				<td> 회원주소 </td>
				<td> <input type="text" name="addr" id="addr"> </td>
			</tr>
			<tr>
				<td> 가입일자 </td>
				<td> <input type="date" name="joindate" id="joindate" placeholder="2016-09-07"> </td>
			</tr>
			<tr>
				<td> 고객등급[A:VIP, B:일반, C:직원] </td>
				<td> <input type="text" name="grade" id="grade"> </td>
			</tr>
			<tr>
				<td> 도시코드 </td>
				<td> <input type="text" name="city" id="city"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"> 
					<input type="submit" value="등록">
					<a href="<%= request.getContextPath() %>/member/memberList"><input type="button" value="조회"></a>
				</td>
			</tr>
		</table>
	</form>
</section>

<script>
	function checkForm(){
		if(document.frm.custname.value.trim() == ""){
			//회원이름이 공백인 경우
			alert("회원성명이 입력되지 않았습니다.");
			document.frm.custname.focus();
			return false;
		}
		if(document.frm.phone.value.trim() == ""){
			//전화번호가 공백인 경우
			alert("전화번호가 입력되지 않았습니다.");
			document.frm.phone.focus();
			return false;
		}
		if(document.frm.addr.value.trim() == ""){
			//주소가 공백인 경우
			alert("주소가 입력되지 않았습니다.");
			document.frm.addr.focus();
			return false;
		}
		if(document.frm.joindate.value.trim() == ""){
			//가입일자 공백인 경우
			alert("가입일자가 입력되지 않았습니다.");
			document.frm.joindate.focus();
			return false;
		}
		if(document.frm.grade.value.trim() == ""){
			//고객등급이 공백인 경우
			alert("고객등급이 입력되지 않았습니다.");
			document.frm.grade.focus();
			return false;
		}
		if(document.frm.city.value.trim() == ""){
			//도시코드가 공백인 경우
			alert("도시코드가 입력되지 않았습니다.");
			document.frm.city.focus();
			return false;
		}
		
		alert("회원등록이 완료되었습니다.");
		return true;
	}
</script>
<%@ include file="../footer.jsp" %>














