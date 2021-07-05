<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action='update.do' method='post'>
	<table border="1">
	
	<input type="hidden" name='mno' value='${vo.mno}'readonly >
		<tr>
			<td>이름:</td>
			<td><input type='text' name='mname' value='${vo.mname}'></td>
		</tr>
		<tr>
			<td>이메일: </td>
			<td><input type='text' name ='email' value="${vo.email}"></td>
		</tr>
		<tr>
			<td>비밀번호:</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type='submit' value='저장'> &nbsp; <input type="reset" > &nbsp; <input type="button" value='취소' onclick="location.href='index.do'"> </td>
		</tr>
	</table>

</form>
</div>
</body>
</html>