<script>
import { ref } from 'vue';
import axios from 'axios';

export default {
    setup() {
        const userData = ref({
            userId: '',
            userName: '',
            userPass: ''
        });

        const submitForm = () => {
            axios.post('http://localhost:80/api/member/regist', userData.value)
                .then(response => {
                    console.log('회원가입 성공:', response.data);
                    alert('회원가입 성공!');
                })
                .catch(error => {
                    console.error('회원가입 오류:', error);
                    alert('쏘리 낫 조인');
                });
        };

        return {
            userData,
            submitForm,
        };
    },
};
</script>

<template>
    <div class="container p-4">
        <h2>회원가입</h2>
        <form @submit.prevent="submitForm" id="registForm">
            <div class="form-group">
                <label for="id">아이디</label>
                <input v-model="userData.userId" type="text" class="form-control" name="userId" id="id"
                    placeholder="아이디를 입력하세요">
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input v-model="userData.userName" type="text" class="form-control" name="userName" id="name"
                    placeholder="이름을 입력하세요">
            </div>
            <div class="form-group">
                <label for="pw">비밀번호</label>
                <input v-model="userData.userPass" type="password" class="form-control" name="userPass" id="pw"
                    placeholder="비밀번호를 입력하세요">
            </div>
            <button type="submit" class="btn btn-primary" id="regist">등록</button>
            <button @click="$router.push('/')" class="btn btn-primary">취소</button>
        </form>
    </div>
</template>

<style scoped></style>
