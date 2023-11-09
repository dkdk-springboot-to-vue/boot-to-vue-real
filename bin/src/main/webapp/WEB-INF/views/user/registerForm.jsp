<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../include/head.jsp" %>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>회원가입</h2>
	  <form id="registForm" >
	  	<input type="hidden" name="action" value="register">
	    <div class="form-group">
	      <label for="id">아이디</label>
	      <input type="text" class="form-control" name="id" id="id" placeholder="아이디">
	    </div>
	    <div class="form-group">
	      <label for="name">이름</label>
	      <input type="text" class="form-control" name="name" id="name" placeholder="이름">
	    </div>
	    <div class="form-group">
	      <label for="pw">비밀번호</label>
	      <input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호" >
	    </div>
	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	</div>
	<%-- --%>
<%@ include file="../include/footer.jsp" %>