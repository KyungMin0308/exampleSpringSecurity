<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Offer Created</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	${offer.name} 가 새로운 제안을 하였습니다.
	
	<a href="${pageContext.request.contextPath}/offers"> Click here to view current offers. </a>
	
</body>
</html>