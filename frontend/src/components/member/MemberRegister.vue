<script setup>

</script>

<template>
    <div class="container p-4">

        <h2>회원가입</h2>
        <form id="registForm" action="${root }/member/regist" method="post">
            <!-- <input type="hidden" name="action" value="register"> -->
            <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" class="form-control" name="userId" id="id" placeholder="아이디를 입력하시죵 ?">
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" class="form-control" name="userName" id="name" placeholder="왓츠유어네임">
            </div>
            <div class="form-group">
                <label for="pw">비밀번호</label>
                <input type="password" class="form-control" name="userPass" id="pw" placeholder="비밀번호를 치기 전에 주변을 살펴보세용 !!">
            </div>
            <button @click="submit" type="submit" class="btn btn-primary" id="regist">등록</button>
            <button @click="$router.push('/')" class="btn btn-primary">취소</button>
        </form>

    </div>
</template>

<style scoped></style>