<script setup>
import { ref, onMounted, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { detailArticle, deleteArticle, registReply } from "@/api/board";

const route = useRoute();
const router = useRouter();

const { articleno } = route.params;

const article = ref({});

const reply = ref({
  articleno: articleno,
  replyContent: "",
  userId: "test",
});

onMounted(() => {
  getArticle();
});

const getArticle = () => {
  console.log("get detail artcle");
  detailArticle(articleno, ({ data }) => {
    console.log(data);
    article.value = data;
  });
};

const moveModify = () => {
  router.push({ name: "article-modify", params: { articleno } });
};

function moveList() {
  router.push({ name: "article-list" });
}

const onDeleteArticle = () => {
  // const { articleno } = route.params;
  console.log(articleno + "번글 삭제하러 가자!!!");
  // API 호출
  deleteArticle(articleno, ({ data }) => {
    console.log(data);
    article.value = data;
    moveList();
  });
};

const replyErrMsg = ref("");

watch(
  () => reply.value.replyContent,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 100) {
      replyErrMsg.value = "내용을 확인해 주세요!!!";
    } else replyErrMsg.value = "";
  },
  { immediate: true }
);

function onSubmit() {
  // event.preventDefault();

  if (replyErrMsg.value) {
    alert(replyErrMsg.value);
  } else {
    writereply();
  }
}

function writereply() {
  console.log("댓글작성");
  registReply(
    reply.value,
    ({ data }) => {
      console.log("writeReply : " + data);
    },
    (error) => {
      console.log(error);
    }
  );
}
</script>

<template>
  <!-- <c:if test="${article eq null}">
    <script>
      alert("글이 삭제되었거나 부적절한 URL 접근입니다.");
      location.href = "${root}/article?action=list";
    </script>
  </c:if> -->

  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <h2 class="my-3 py-3 shadow-sm bg-light text-center">
        <mark class="sky">글보기</mark>
      </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
      <div class="row my-2">
        <h2 class="text-secondary px-5">{{ article.articleNo }}. {{ article.subject }}</h2>
      </div>
      <div class="row">
        <div class="col-md-8">
          <div class="clearfix align-content-center">
            <img
              class="avatar me-2 float-md-start bg-light p-2"
              src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg"
            />
            <p>
              <span class="fw-bold">{{ article.userId }}</span> <br />
              <span class="text-secondary fw-light">
                {{ article.registerTime }} 조회 : {{ article.hit }}
              </span>
            </p>
          </div>
        </div>

        <div class="col-md-4 align-self-center text-end"></div>
        <div class="divider mb-3"></div>
        <div class="text-secondary">{{ article.content }}</div>

        <div style="height: 250px"></div>

        <div class="divider mt-3 mb-3"></div>
        <div class="d-flex justify-content-end">
          <button type="button" id="btn-list" class="btn btn-outline-primary mb-3">글목록</button>

          <c:if test="${userInfo.userId eq article.userId}">
            <button
              type="button"
              id="btn-mv-modify"
              class="btn btn-outline-success mb-3 ms-1"
              @click="moveModify"
            >
              글수정
            </button>
            <button
              type="button"
              id="btn-delete"
              class="btn btn-outline-danger mb-3 ms-1"
              @click="onDeleteArticle"
            >
              글삭제
            </button>
          </c:if>
        </div>

        <hr />
        <div>
          <form @submit.prevent="onSubmit">
            <div class="mb-3">
              <label for="subject" class="form-label">댓글 작성 </label>
              <input
                type="text"
                class="form-control"
                id="content"
                name="replyCotent"
                placeholder="입력하시오..."
                v-model="reply.replyContent"
              />
            </div>

            <div class="d-flex justify-content-end">
              <input
                type="submit"
                id="btn-reply"
                class="btn btn-outline-primary mb-3"
                value="작성 "
              />
            </div>
          </form>
        </div>

        <h4>댓글 목록</h4>
        <table class="table table-hover">
          <thead>
            <tr class="text-center">
              <th scope="col">작성자</th>
              <th scope="col">댓글</th>
            </tr>
          </thead>
          <tbody>
            <!-- 댓글 -->
            <tr class="text-center" v-for="reply in article.replies">
              <td>{{ reply.userId }}</td>
              <td>{{ reply.replyContent }}</td>
            </tr>
            <!-- <c:forEach var="reply" items="${article.replies}">
              <tr class="text-center">
                <td>${reply.userId}</td>
                <td>${reply.replyCotent}</td>
              </tr>
            </c:forEach> -->
          </tbody>
        </table>

        <div style="height: 50px"></div>
        <hr />
        <div style="height: 50px"></div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
