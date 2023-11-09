<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<title>Insert title here</title>
<%@ include file="../include/head.jsp" %>
</head>
<body>
	<%@ include file="../include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<h2>로그인</h2>
		<form action="${root}/member/login" method="post">
			<input type="hidden" name="action" value="login"> 
			<div class="form-group">
				<label for="id">id:</label> <input type="text" class="form-control"
					id="id" name="userId" placeholder="ID 입력" value="">
			</div>
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" id="pw" name="userPass" placeholder="비밀번호 입력">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					아이디 기억하기
				</label>
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
			<a class="btn btn-secondary" href="${root}/member/regist">회원가입</a>
			<a class="btn btn-secondary" href="${root}/member/findpw">비밀번호 찾기</a>
		</form>
	</div>