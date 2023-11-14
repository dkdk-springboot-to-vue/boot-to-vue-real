<script>
import { ref } from 'vue';
import axios from 'axios';

export default {
    setup() {
        const findData = ref({
            userId: '',
            foundPassword: null,
        });

        const submitForm = () => {
            axios.get(`http://localhost:80/api/member/findpw/${findData.value.userId}`)
                .then(response => {
                    if (response.status === 200) {
                        findData.value.foundPassword = response.data;
                    } else if (response.status === 404) {
                        findData.value.foundPassword = '';
                        alert('아이디 못찾음');
                    }
                })
                .catch(error => {
                    console.error('비밀번호 찾기 오류:', error);
                    alert('입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.');
                    findData.value.foundPassword = '';
                });
        };

        return {
            findData,
            submitForm,
        };
    },
};
</script>

<template>
    <div class="container p-4">
        <h2>비밀번호 찾기</h2>
        <form @submit.prevent="submitForm">
            <div class="form-group">
                <label for="id">ID:</label>
                <input v-model="findData.userId" type="text" class="form-control" id="id" placeholder="ID 입력">
            </div>
            <button type="submit" class="btn btn-primary">비밀번호 찾기</button>
        </form>

        <div v-if="findData.foundPassword !== null">
            <p v-if="findData.foundPassword !== ''">찾은 비밀번호: {{ findData.foundPassword }}</p>
            <p v-else-if="findData.foundPassword === ''">입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.</p>
        </div>
    </div>
</template>

<style scoped></style>
