<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${name1 }<br>
이메일 :${email1 }<br>
<br>
이름 : ${name2 }<br>
이메일 :${email2 }<br>
번호2:${no2}<br>
<br>
이름 : ${vo.name }<br>
이메일 :${vo.email }<br>
번호3:${vo.no}<br>
<br>
이름 : ${memberVo.name }<br>
이메일 :${memberVo.email }<br>
번호3:${memberVo.no} <br>
id : ${id }	<br>
hobby ${memberVo.hobby }
</body>
</html>