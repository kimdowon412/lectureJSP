<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<section>
	<h1>오디션 등록</h1>
	<form action="<%=request.getContextPath()%>/artist/artistInsert"
		method="post" name="frm" onsubmit="return checkForm()"
		onreset="return resetForm()">
		<table>
			<tr>
				<td>참가번호</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>참가자명</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" id="birth"></td>
			<tr>
				<td>성별(남성:M, 여성:F)</td>
				<td><input type="radio" name="gender" id="gender" value="M">남
					<input type="radio" name="gender" id="gender" value="F">여</td>
			</tr>
			<tr>
				<td>특기(보컬:1, 댄스:2, 랩:3)</td>
				<td><select name="talent" id="talent">
						<option value="none" selected disabled>특기선택</option>
						<option value="1">보컬</option>
						<option value="2">댄스</option>
						<option value="3">랩</option>
				</select></td>
			</tr>
			<tr>
				<td>소속사</td>
				<td><input type="text" name="agency" id="agency"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="오디션 등록">
					&nbsp;&nbsp; <input type="reset" value="다시쓰기"></td>
			</tr>
		</table>
	</form>
</section>

<script>
	function checkForm() {
		if (document.frm.id.value.trim() == "") {
			alert("참가번호가 입력되지 않았습니다.");
			document.frm.id.focus();
			return false;
		}
		if (document.frm.name.value.trim() == "") {
			alert("참가자명이 입력되지 않았습니다.");
			document.frm.name.focus();
			return false;
		}
		if (document.frm.birth.value.trim() == "") {
			alert("생년월일이 입력되지 않았습니다.");
			document.frm.birth.focus();
			return false;
		}
		if (document.frm.gender.value.trim() == "") {
			alert("성별이 입력되지 않았습니다.");
			return false;
		}
		if (document.frm.talent.value.trim() == "") {
			alert("특기가 입력되지 않았습니다.");
			document.frm.talent.focus();
			return false;
		}
		if (document.frm.agency.value.trim() == "") {
			alert("소속사가 입력되지 않았습니다.");
			document.frm.agency.focus();
			return false;
		}

		alert("오디션 등록이 완료되었습니다.");
		return true;
	}

	function resetForm() {
		alert("전체 내용을 지우고 다시 입력합니다.");
		document.frm.reset();
		document.frm.id.focus();
	}
</script>
<%@ include file="../footer.jsp"%>