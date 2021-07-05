<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div>
		<span style="float:right;">
			<c:if test="${empty memberInfo}">
				<button onclick="location.href='form.do'">로그인</button> 
				<button onclick="location.href='write.do'">회원가입</button> 
			</c:if>
			<c:if test="${!empty memberInfo}">
			 	(${ memberInfo.mname})
				<button onclick="location.href='logout.do'">로그아웃</button> 
				<button onclick="location.href='mypage.do?${memberInfo.mno}'">정보수정</button> 
			</c:if>
		</span>
	</div>
	<div>
		<c:forEach var="member" items="${list }">
			${member.mno }, ${member.mname }, ${member.email } <br>
		</c:forEach>
	</div>
</body>
</html>