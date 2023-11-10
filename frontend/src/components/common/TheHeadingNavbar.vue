<script setup></script>

<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav me-auto">
      <li class="nav-item"><a class="nav-link" href=""> map </a></li>
      <li class="nav-item"><a class="nav-link" href=""> user </a></li>
      <li class="nav-item"><a class="nav-link" href=""> board </a></li>
    </ul>
    <!-- <c:choose> -->
    <!-- session에 값이 없다면 로그인이 안됐다 !  -->
    <!-- <c:when test="${empty userInfo}"> -->
    <ul class="navbar-nav">
      <li class="nav-item"><a class="nav-link" href="${root}/member/login">로그인</a></li>
      <li class="nav-item"><a class="nav-link" href="${root}/member/regist">회원가입</a></li>
    </ul>
    <!-- </c:when> -->
    <!-- session에 값이 있다면 로그인 됬다 !  -->
    <!-- <c:otherwise> -->
    <ul class="navbar-nav">
      <li class="nav-item"><a class="nav-link disabled">${userInfo}님 반갑습니다.</a></li>
      <li class="nav-item"><a class="nav-link" href="${root}/member/logout">로그아웃</a></li>
    </ul>
    <!-- </c:otherwise> -->
    <!-- </c:choose> -->
  </nav>
</template>

<style scoped></style>
