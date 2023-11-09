<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include/head.jsp"%>
</head>
<body>
	<%@ include file="include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">

		<h2>비밀번호 찾기</h2>
		<form id="findForm">
			<input type="hidden" name="action" value="find">
			<div class="form-group">
				<label for="id">아이디</label> <input type="text" class="form-control"
					name="id" id="id" placeholder="아이디">
			</div>
			<div class="form-group">
				<label for="name">이름</label> <input type="text" class="form-control"
					name="name" id="name" placeholder="이름">
			</div>
			<div class="form-group">
					<p>비밀번호 찾기 결과: ${result }</p>
			</div>
			<button type="submit" class="btn btn-primary" id="find">찾기</button>
			<a class="btn btn-secondary" href="${root}/user?action=loginform">로그인 화면</a>
		</form>

	</div>
	<%-- --%>
	<%@ include file="include/footer.jsp"%>