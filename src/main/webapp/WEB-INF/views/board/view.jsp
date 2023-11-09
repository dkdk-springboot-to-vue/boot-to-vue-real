<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%@ include file="../include/nav.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${article eq null}">
	<script>
		alert("글이 삭제되었거나 부적절한 URL 접근입니다.");
		location.href = "${root}/article?action=list";
	</script>
</c:if>

<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">글보기</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<div class="row my-2">
			<h2 class="text-secondary px-5">${article.articleNo}.
				${article.subject}</h2>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="clearfix align-content-center">
					<img class="avatar me-2 float-md-start bg-light p-2"
						src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" />
					<p>
						<span class="fw-bold">${article.userId}</span> <br /> <span
							class="text-secondary fw-light"> ${article.registerTime}
							조회 : ${article.hit} </span>
					</p>
				</div>
			</div>

			<div class="col-md-4 align-self-center text-end"></div>
			<div class="divider mb-3"></div>
			<div class="text-secondary">${article.content}</div>



			<div style="height: 250px"></div>

			<div class="divider mt-3 mb-3"></div>
			<div class="d-flex justify-content-end">
				<button type="button" id="btn-list"
					class="btn btn-outline-primary mb-3">글목록</button>

				<c:if test="${userInfo.userId eq article.userId}">
					<button type="button" id="btn-mv-modify"
						class="btn btn-outline-success mb-3 ms-1">글수정</button>
					<button type="button" id="btn-delete"
						class="btn btn-outline-danger mb-3 ms-1">글삭제</button>
				</c:if>
			</div>

			<hr>
			<h4>댓글 목록</h4>
			<table class="table table-hover">
				<thead>
					<tr class="text-center">
						<th scope="col">작성자</th>
						<th scope="col">댓글</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reply" items="${article.replies}">
						<tr class="text-center">
							<td>${reply.userId}</td>
							<td>${reply.replyCotent}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div style="height: 50px"></div>
			<hr>
			<div style="height: 50px"></div>

			<div>
				<form method="POST" action="${root}/article">
					<input type="hidden" name="action" value="reply"> 
					<input type="hidden" name="articleNo" value="${article.articleNo}">
					<div class="mb-3">
						<label for="subject" class="form-label">댓글 작성 </label> 
						<input type="text" class="form-control" id="content" name="content" placeholder="입력하시오..." />
					</div>

					<div class="d-flex justify-content-end">
						<input type="submit" id="btn-reply" class="btn btn-outline-primary mb-3" value="작성 ">
					</div>
				</form>
			</div>

		</div>
	</div>
</div>
<script>
	document.querySelector("#btn-list").addEventListener("click", function() {
		location.href = "${root}/board/list";
	});
	document
			.querySelector("#btn-mv-modify")
			.addEventListener(
					"click",
					function() {
						alert("글수정");
						location.href = "${root}/board/modify/${article.articleNo}";
					});
	document
			.querySelector("#btn-delete")
			.addEventListener(
					"click",
					function() {
						alert("글삭제");
						location.href = "${root}/board/delete/${article.articleNo}";
					});

	/* 	document
			.querySelector("#btn-reply")
			.addEventListener("click", function() {
				let form = document.querySelector("#form-reply");
		          form.setAttribute("action", "${root}/article");
		          form.submit();}); */

	/* alert("댓글 추가");
	location.href = "${root}/article?action=reply&articleno=${article.articleNo}";
	});  */
</script>
