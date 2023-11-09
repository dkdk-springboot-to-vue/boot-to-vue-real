<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp"%>
<meta charset="utf-8" />
<title>Kakao 지도 시작하기</title>
</head>
<body>
	<%@ include file="../include/nav.jsp"%>
	<div id="map" style="width: 1500px; height: 800px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d7b65c02e09f25693375de0c659e2ae4"></script>
	<script>
		<c:if test="${not empty attractionList}">
		<c:set var="latitude" value="${attractionList[0].latitude}" />
		<c:set var="longitude" value="${attractionList[0].longitude}" />
		</c:if>

		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng('${latitude}', '${longitude}'),
			level : 3
		};
		var map = new kakao.maps.Map(container, options);

		<c:forEach var="attraction" items="${attractionList}">
		var latitude = "${attraction.latitude}";
		var longitude = "${attraction.longitude}";
		var position = new kakao.maps.LatLng(latitude, longitude);
		var marker = new kakao.maps.Marker({
			position : position
		});
		marker.setMap(map);
		</c:forEach>
	</script>
</body>
</html>