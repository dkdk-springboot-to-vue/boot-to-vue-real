<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<title>Insert title here</title>
<%@ include file="../include/head.jsp"%>
</head>
<body>
	<%@ include file="../include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<h2>회원정보</h2>
		<div class="container p-4">

			<form id="loginedForm">
				<input type="hidden" name="action" value="update">
				<div class="form-group">
					<label for="id">아이디 : ${userInfo.userId}
				</div>
				<div class="form-group">
					<label for="name">이름</label> <input type="text"
						class="form-control" name="name" id="name" placeholder= "${userInfo.userName}" >
				</div>
				<div class="form-group">
					<label for="pw">비밀번호</label> <input type="password"
						class="form-control" name="pw" id="pw" placeholder="${userInfo.userPass}">
				</div>
				<button type="submit" class="btn btn-primary" id="regist">회원수정</button>
			</form>
		</div>
		
		<%-- 로그인된 회원 삭제및 로그아웃 동시 진행 --%>
		<a class="btn btn-secondary" href="${root}/user?action=delete">회원탈퇴</a>
		<%-- 로그아웃 --%>
		<a class="btn btn-secondary" href="${root}/user?action=logout">로그아웃</a>

	</div>