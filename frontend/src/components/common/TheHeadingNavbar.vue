<script setup>
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

// You may need to adjust this to get the user information from your application state
const userInfo = ref(/* user information here */);

const route = useRoute();
const router = useRouter();

const logout = () => {
  // Implement your logout logic here (clear session, etc.)
  // For now, let's assume you have a '/member/logout' endpoint
  router.push('/member/logout');
};
</script>

<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav me-auto">
      <li class="nav-item">
        <router-link :to="{ name: 'main' }" class="nav-link">홈</router-link>
      </li>
      <li class="nav-item"><a class="nav-link" href=""> map </a></li>
      <li class="nav-item"><a class="nav-link" href=""> user </a></li>
      <router-link :to="{ name: 'board' }" class="nav-link">board</router-link>
    </ul>

    <ul class="navbar-nav">
      <!-- Check if the user is logged in -->
      <template v-if="!userInfo">
        <li class="nav-item"><router-link :to="{ name: 'member-login' }" class="nav-link">로그인</router-link></li>
        <li class="nav-item"><router-link :to="{ name: 'member' }" class="nav-link">회원가입</router-link></li>
      </template>

      <template v-else>
        <li class="nav-item"><a class="nav-link disabled"> {{ userInfo.userId }}님 반갑습니다.</a></li>
        <li class="nav-item"><a class="nav-link" @click="logout">로그아웃</a></li>
      </template>
    </ul>
  </nav>
</template>

<style scoped></style>
