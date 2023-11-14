<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const userInfo = ref({
    userId: '',
    userName: '',
    userPass: '',
});

onMounted(async () => {
    // Fetch user information when the component is mounted
    await fetchUserInfo();
});

const fetchUserInfo = async () => {
    try {
        // Assuming that the user ID is stored in the session or vuex store
        const userId = 'replace_with_logged_in_user_id';  // Replace with actual logged-in user ID
        const response = await axios.get(`http://localhost:80/api/member/user/${userId}`);
        userInfo.value = response.data;
    } catch (error) {
        console.error('Error fetching user information:', error);
        // Handle error
    }
};

const updateUserInfo = async () => {
    try {
        const response = await axios.put('http://localhost:80/api/member/user', userInfo.value);
        console.log('User information updated:', response.data);
        // You may want to show a success message or navigate to another page after updating
    } catch (error) {
        console.error('Error updating user information:', error);
        // Handle error
    }
};

const deleteUser = async () => {
    try {
        const response = await axios.delete(`http://localhost:80/api/member/user/${userInfo.value.userId}`);
        console.log('User deleted:', response.data);
        // You may want to show a success message or navigate to another page after deleting
    } catch (error) {
        console.error('Error deleting user:', error);
        // Handle error
    }
};

const logout = () => {
    // Implement your logout logic, e.g., clear session, navigate to login page, etc.
};

</script>

<template>
    <div class="container p-4">
        <h2>회원정보</h2>
        <form @submit.prevent="updateUserInfo" id="loginedForm">
            <input type="hidden" name="action" value="update">
            <div class="form-group">
                <label for="id">아이디 : {{ userInfo.userId }}</label>
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input v-model="userInfo.userName" type="text" class="form-control" name="name" id="name"
                    placeholder="이름을 입력하세요">
            </div>
            <div class="form-group">
                <label for="pw">비밀번호</label>
                <input v-model="userInfo.userPass" type="password" class="form-control" name="pw" id="pw"
                    placeholder="비밀번호를 입력하세요">
            </div>
            <button type="submit" class="btn btn-primary" id="regist">회원수정</button>
        </form>

        <!-- 로그인된 회원 삭제및 로그아웃 동시 진행 -->
        <button @click="deleteUser" class="btn btn-secondary">회원탈퇴</button>
        <!-- 로그아웃 -->
        <button @click="logout" class="btn btn-secondary">로그아웃</button>
    </div>
</template>

<style scoped></style>
