<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { listArticle } from "@/api/board";

import BoardListItem from "@/components/board/item/BoardListItem.vue";

const articles = ref([]);

const param = ref({
  pgno: 1,
  key: "subject",
  word: "d",
});

onMounted(() => {
  getArticleList();
});

const getArticleList = () => {
  console.log("글 목록 얻어오기", param.value);
  // API 호출
  listArticle(
    param.value,
    ({ data }) => {
      console.log("data : " + data);
      //   articles.value = data;
      articles.value = data;
      console.log(articles.value);
    },
    (error) => {
      console.log(error);
    }
  );
};
</script>

<template>
  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <h2 class="my-3 py-3 shadow-sm bg-light text-center">
        <mark class="sky">글목록</mark>
      </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
      <div class="row align-self-center mb-2">
        <div class="col-md-2 text-start">
          <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
            글쓰기
          </button>
        </div>
        <div class="col-md-7 offset-3">
          <form class="d-flex" id="form-search" action="">
            <input type="hidden" name="action" value="list" />
            <input type="hidden" name="pgno" value="1" />
            <select
              name="key"
              id="key"
              class="form-select form-select-sm ms-5 me-1 w-50"
              aria-label="검색조건"
            >
              <option value="" selected>검색조건</option>
              <option value="article_no">글번호</option>
              <option value="subject">제목</option>
              <option value="user_id">작성자</option>
            </select>
            <div class="input-group input-group-sm">
              <input
                type="text"
                name="word"
                id="word"
                class="form-control"
                placeholder="검색어..."
              />
              <button id="btn-search" class="btn btn-dark" type="button">검색</button>
            </div>
          </form>
        </div>
      </div>
      <table class="table table-hover">
        <thead>
          <tr class="text-center">
            <th scope="col">글번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">조회수</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
          <BoardListItem v-for="article in articles" :key="article.acticleNo" :article="article">
          </BoardListItem>
        </tbody>
      </table>
    </div>
    <!-- <div class="row">${navigation.navigator}</div> -->
  </div>
</template>

<style scoped></style>
