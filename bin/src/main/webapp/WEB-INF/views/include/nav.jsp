<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root }/attr"> map </a></li>
		<li class="nav-item"><a class="nav-link" href="${root }/user/loginForm.jsp"> user </a></li>
		<li class="nav-item"><a class="nav-link" href="${root }/board/list"> board </a></li>
		
	</ul>
	<c:choose>
		<%-- session에 값이 없다면 로그인이 안됬다 ! --%>
		<c:when test="${empty userInfo}">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="${root}/user?action=loginform">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="${root}/user?action=registerform">회원가입</a></li>
			</ul>
		</c:when>
		<%-- session에 값이 있다면 로그인 됬다 !  --%>
		<c:otherwise>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link disabled">${userInfo.userId}님
						반갑습니다.</a></li>
				<li class="nav-item"><a class="nav-link" href="${root}/user?action=logout">로그아웃</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>