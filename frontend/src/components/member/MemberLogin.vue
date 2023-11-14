<script>
import { ref } from 'vue';
import axios from 'axios';

export default {
    setup() {
        const loginData = ref({
            userId: '',
            userPass: '',
        });

        const submitLoginForm = () => {
            axios.post('http://localhost:80/api/member/login', loginData.value)
                .then(response => {
                    if (response.status === 200) {
                        console.log('로그인 성공:', response.data);
                        alert('로긴 성공 ㅊㅊㅊ');


                    } else {
                        console.error('로그인 실패:', response);
                        alert('로긴 실패 ㅜㅜ');
                    }
                })
                .catch(error => {
                    console.error('비번 다르게 치면 여길로 온다', error);
                    alert('로긴 실패 ㅜㅜ');
                });
        };

        return {
            loginData,
            submitLoginForm,
        };
    },
};
</script>

<template>
    <div class="container p-4">
        <h2>로그인</h2>
        <form @submit.prevent="submitLoginForm">
            <div class="form-group">
                <label for="id">id:</label>
                <input type="text" class="form-control" id="id" v-model="loginData.userId" placeholder="ID 입력">
            </div>
            <div class="form-group">
                <label for="pw">Password:</label>
                <input type="password" class="form-control" id="pw" v-model="loginData.userPass" placeholder="비밀번호 입력">
            </div>
            <div class="form-group form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="remember"> 아이디 기억하기
                </label>
            </div>
            <button type="submit" class="btn btn-primary">로그인</button>
            <router-link :to="{ name: 'member' }" class="btn btn-secondary">회원가입</router-link>
            <router-link :to="{ name: 'member-find' }" class="btn btn-secondary">비밀번호 찾기</router-link>
        </form>
    </div>
</template>

<style scoped></style>
