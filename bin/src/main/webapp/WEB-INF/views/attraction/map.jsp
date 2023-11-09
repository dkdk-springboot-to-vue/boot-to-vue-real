<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp"%>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<%@ include file="../include/nav.jsp"%>
	<form action="/attr/mapview" method="post">
		<div class="sido">
			<select name="sido" id="sido">
				<c:forEach var="sido" items="${sidoList}">
					<option value="${sido.sido_code}">${sido.sido_name}</option>
				</c:forEach>
			</select> <select name="gugun" id="gugun">
				<c:forEach var="gugun" items="${gugunList}">
					<option value="${gugun.gugun_code}">${gugun.gugun_name}</option>
				</c:forEach>

			</select>
			<button type="submit">검색</button>
		</div>
	</form>

	<script>
		$(document)
				.ready(
						function() {
							$('#sido')
									.change(
											function() {
												let sidoCode = $(this).val();
												//console.log("sidoCode : " + sidoCode);

												$
														.ajax({
															url : '/attr/gugun/'+sidoCode,
															type : 'GET',
/*  															data : {
																'sido_code' : sidoCode
															}, */
															dataType : 'json', 
															success : function(
																	data) {
																let $gugun = $('#gugun');
																console.log("data"+ data)
																$gugun.empty(); // 기존의 구/군 옵션을 삭제
																$gugun
																		.append('<option value="">구군선택</option>'); // 기본 옵션 추가
																$
																		.each(
																				data,
																				function(
																						index,
																						gugun) {
																					$gugun
																							.append('<option value="' + gugun.gugun_code + '">'
																									+ gugun.gugun_name
																									+ '</option>');
																				});
															}
														});
											});
						});
	</script>

</body>
</html>
