<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { registArticle, detailArticle } from "@/api/board";

const router = useRouter();
const route = useRoute();

const props = defineProps({ type: String });

const isUseId = ref(false);

const article = ref({
  articleNo: 0,
  subject: "",
  content: "",
  userId: "ssafy",
  userName: "",
  hit: 0,
  registerTime: "",
});

if (props.type === "modify") {
  let { articleno } = route.params;
  console.log(articleno + "번글 얻어와서 수정");
  detailArticle(
    articleno,
    ({ data }) => {
      console.log("data : " + data);
      //   articles.value = data;
      article.value = data;
      console.log(article.value);
    },
    (error) => {
      console.log(error);
    }
  );
  isUseId.value = true;
}

const subjectErrMsg = ref("");
const contentErrMsg = ref("");
watch(
  () => article.value.subject,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 30) {
      subjectErrMsg.value = "제목을 확인해 주세요!!!";
    } else subjectErrMsg.value = "";
  },
  { immediate: true }
);
watch(
  () => article.value.content,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 500) {
      contentErrMsg.value = "내용을 확인해 주세요!!!";
    } else contentErrMsg.value = "";
  },
  { immediate: true }
);

function onSubmit() {
  // event.preventDefault();

  if (subjectErrMsg.value) {
    alert(subjectErrMsg.value);
  } else if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    props.type === "regist" ? writeArticle() : updateArticle();
  }
}

function writeArticle() {
  console.log("글등록하자!!", article.value);
  registArticle(
    article.value,
    ({ data }) => {
      console.log("writeArticle : " + data);
    },
    (error) => {
      console.log(error);
    }
  );
  moveList();
}

function updateArticle() {
  console.log(article.value.articleNo + "번글 수정하자!!", article.value);
  // API 호출
}

function moveList() {
  router.push({ name: "article-list" });
}
</script>

<template>
  <form id="form-register" @submit.prevent="onSubmit">
    <input type="hidden" name="action" value="write" />
    <!-- 세션 없어서 임시로 ssafy계정이 글작성 -->
    <!-- <input type="hidden" name="userId" value="ssafy" /> -->
    <div class="mb-3">
      <label for="subject" class="form-label">제목 : </label>
      <input
        type="text"
        class="form-control"
        id="subject"
        name="subject"
        placeholder="제목..."
        v-model="article.subject"
      />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea
        class="form-control"
        id="content"
        name="content"
        rows="7"
        v-model="article.content"
      ></textarea>
    </div>
    <div class="col-auto text-center">
      <button type="submit" id="btn-register" class="btn btn-outline-primary mb-3" v-if="isUseId">
        글수정
      </button>
      <button type="submit" id="btn-register" class="btn btn-outline-primary mb-3" v-else>
        글작성
      </button>
      <button type="reset" class="btn btn-outline-danger mb-3">초기화</button>
    </div>
  </form>
</template>

<style scoped></style>
